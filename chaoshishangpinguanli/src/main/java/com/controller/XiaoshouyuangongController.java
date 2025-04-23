
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 销售员工
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xiaoshouyuangong")
public class XiaoshouyuangongController {
    private static final Logger logger = LoggerFactory.getLogger(XiaoshouyuangongController.class);

    @Autowired
    private XiaoshouyuangongService xiaoshouyuangongService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private CaigouyuangongService caigouyuangongService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("采购员工".equals(role))
            params.put("caigouyuangongId",request.getSession().getAttribute("userId"));
        else if("销售员工".equals(role))
            params.put("xiaoshouyuangongId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = xiaoshouyuangongService.queryPage(params);

        //字典表数据转换
        List<XiaoshouyuangongView> list =(List<XiaoshouyuangongView>)page.getList();
        for(XiaoshouyuangongView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XiaoshouyuangongEntity xiaoshouyuangong = xiaoshouyuangongService.selectById(id);
        if(xiaoshouyuangong !=null){
            //entity转view
            XiaoshouyuangongView view = new XiaoshouyuangongView();
            BeanUtils.copyProperties( xiaoshouyuangong , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody XiaoshouyuangongEntity xiaoshouyuangong, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xiaoshouyuangong:{}",this.getClass().getName(),xiaoshouyuangong.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<XiaoshouyuangongEntity> queryWrapper = new EntityWrapper<XiaoshouyuangongEntity>()
            .eq("username", xiaoshouyuangong.getUsername())
            .or()
            .eq("xiaoshouyuangong_phone", xiaoshouyuangong.getXiaoshouyuangongPhone())
            .or()
            .eq("xiaoshouyuangong_id_number", xiaoshouyuangong.getXiaoshouyuangongIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XiaoshouyuangongEntity xiaoshouyuangongEntity = xiaoshouyuangongService.selectOne(queryWrapper);
        if(xiaoshouyuangongEntity==null){
            xiaoshouyuangong.setCreateTime(new Date());
            xiaoshouyuangong.setPassword("123456");
            xiaoshouyuangongService.insert(xiaoshouyuangong);
            return R.ok();
        }else {
            return R.error(511,"账户或者销售员工手机号或者销售员工身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XiaoshouyuangongEntity xiaoshouyuangong, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,xiaoshouyuangong:{}",this.getClass().getName(),xiaoshouyuangong.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<XiaoshouyuangongEntity> queryWrapper = new EntityWrapper<XiaoshouyuangongEntity>()
            .notIn("id",xiaoshouyuangong.getId())
            .andNew()
            .eq("username", xiaoshouyuangong.getUsername())
            .or()
            .eq("xiaoshouyuangong_phone", xiaoshouyuangong.getXiaoshouyuangongPhone())
            .or()
            .eq("xiaoshouyuangong_id_number", xiaoshouyuangong.getXiaoshouyuangongIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XiaoshouyuangongEntity xiaoshouyuangongEntity = xiaoshouyuangongService.selectOne(queryWrapper);
        if("".equals(xiaoshouyuangong.getXiaoshouyuangongPhoto()) || "null".equals(xiaoshouyuangong.getXiaoshouyuangongPhoto())){
                xiaoshouyuangong.setXiaoshouyuangongPhoto(null);
        }
        if(xiaoshouyuangongEntity==null){
            xiaoshouyuangongService.updateById(xiaoshouyuangong);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者销售员工手机号或者销售员工身份证号已经被使用");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        xiaoshouyuangongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<XiaoshouyuangongEntity> xiaoshouyuangongList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            XiaoshouyuangongEntity xiaoshouyuangongEntity = new XiaoshouyuangongEntity();
//                            xiaoshouyuangongEntity.setUsername(data.get(0));                    //账户 要改的
//                            //xiaoshouyuangongEntity.setPassword("123456");//密码
//                            xiaoshouyuangongEntity.setXiaoshouyuangongUuidNumber(data.get(0));                    //工号 要改的
//                            xiaoshouyuangongEntity.setXiaoshouyuangongName(data.get(0));                    //销售员工姓名 要改的
//                            xiaoshouyuangongEntity.setXiaoshouyuangongPhone(data.get(0));                    //销售员工手机号 要改的
//                            xiaoshouyuangongEntity.setXiaoshouyuangongIdNumber(data.get(0));                    //销售员工身份证号 要改的
//                            xiaoshouyuangongEntity.setXiaoshouyuangongPhoto("");//照片
//                            xiaoshouyuangongEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            xiaoshouyuangongEntity.setXiaoshouyuangongEmail(data.get(0));                    //电子邮箱 要改的
//                            xiaoshouyuangongEntity.setCreateTime(date);//时间
                            xiaoshouyuangongList.add(xiaoshouyuangongEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //工号
                                if(seachFields.containsKey("xiaoshouyuangongUuidNumber")){
                                    List<String> xiaoshouyuangongUuidNumber = seachFields.get("xiaoshouyuangongUuidNumber");
                                    xiaoshouyuangongUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> xiaoshouyuangongUuidNumber = new ArrayList<>();
                                    xiaoshouyuangongUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("xiaoshouyuangongUuidNumber",xiaoshouyuangongUuidNumber);
                                }
                                //销售员工手机号
                                if(seachFields.containsKey("xiaoshouyuangongPhone")){
                                    List<String> xiaoshouyuangongPhone = seachFields.get("xiaoshouyuangongPhone");
                                    xiaoshouyuangongPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> xiaoshouyuangongPhone = new ArrayList<>();
                                    xiaoshouyuangongPhone.add(data.get(0));//要改的
                                    seachFields.put("xiaoshouyuangongPhone",xiaoshouyuangongPhone);
                                }
                                //销售员工身份证号
                                if(seachFields.containsKey("xiaoshouyuangongIdNumber")){
                                    List<String> xiaoshouyuangongIdNumber = seachFields.get("xiaoshouyuangongIdNumber");
                                    xiaoshouyuangongIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> xiaoshouyuangongIdNumber = new ArrayList<>();
                                    xiaoshouyuangongIdNumber.add(data.get(0));//要改的
                                    seachFields.put("xiaoshouyuangongIdNumber",xiaoshouyuangongIdNumber);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<XiaoshouyuangongEntity> xiaoshouyuangongEntities_username = xiaoshouyuangongService.selectList(new EntityWrapper<XiaoshouyuangongEntity>().in("username", seachFields.get("username")));
                        if(xiaoshouyuangongEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XiaoshouyuangongEntity s:xiaoshouyuangongEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //工号
                        List<XiaoshouyuangongEntity> xiaoshouyuangongEntities_xiaoshouyuangongUuidNumber = xiaoshouyuangongService.selectList(new EntityWrapper<XiaoshouyuangongEntity>().in("xiaoshouyuangong_uuid_number", seachFields.get("xiaoshouyuangongUuidNumber")));
                        if(xiaoshouyuangongEntities_xiaoshouyuangongUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XiaoshouyuangongEntity s:xiaoshouyuangongEntities_xiaoshouyuangongUuidNumber){
                                repeatFields.add(s.getXiaoshouyuangongUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [工号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //销售员工手机号
                        List<XiaoshouyuangongEntity> xiaoshouyuangongEntities_xiaoshouyuangongPhone = xiaoshouyuangongService.selectList(new EntityWrapper<XiaoshouyuangongEntity>().in("xiaoshouyuangong_phone", seachFields.get("xiaoshouyuangongPhone")));
                        if(xiaoshouyuangongEntities_xiaoshouyuangongPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XiaoshouyuangongEntity s:xiaoshouyuangongEntities_xiaoshouyuangongPhone){
                                repeatFields.add(s.getXiaoshouyuangongPhone());
                            }
                            return R.error(511,"数据库的该表中的 [销售员工手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //销售员工身份证号
                        List<XiaoshouyuangongEntity> xiaoshouyuangongEntities_xiaoshouyuangongIdNumber = xiaoshouyuangongService.selectList(new EntityWrapper<XiaoshouyuangongEntity>().in("xiaoshouyuangong_id_number", seachFields.get("xiaoshouyuangongIdNumber")));
                        if(xiaoshouyuangongEntities_xiaoshouyuangongIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XiaoshouyuangongEntity s:xiaoshouyuangongEntities_xiaoshouyuangongIdNumber){
                                repeatFields.add(s.getXiaoshouyuangongIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [销售员工身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        xiaoshouyuangongService.insertBatch(xiaoshouyuangongList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }


    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        XiaoshouyuangongEntity xiaoshouyuangong = xiaoshouyuangongService.selectOne(new EntityWrapper<XiaoshouyuangongEntity>().eq("username", username));
        if(xiaoshouyuangong==null || !xiaoshouyuangong.getPassword().equals(password))
            return R.error("账号或密码不正确");
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(.getRoleTypes());
        String token = tokenService.generateToken(xiaoshouyuangong.getId(),username, "xiaoshouyuangong", "销售员工");
        R r = R.ok();
        r.put("token", token);
        r.put("role","销售员工");
        r.put("username",xiaoshouyuangong.getXiaoshouyuangongName());
        r.put("tableName","xiaoshouyuangong");
        r.put("userId",xiaoshouyuangong.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody XiaoshouyuangongEntity xiaoshouyuangong){
//    	ValidatorUtils.validateEntity(user);
        Wrapper<XiaoshouyuangongEntity> queryWrapper = new EntityWrapper<XiaoshouyuangongEntity>()
            .eq("username", xiaoshouyuangong.getUsername())
            .or()
            .eq("xiaoshouyuangong_phone", xiaoshouyuangong.getXiaoshouyuangongPhone())
            .or()
            .eq("xiaoshouyuangong_id_number", xiaoshouyuangong.getXiaoshouyuangongIdNumber())
            ;
        XiaoshouyuangongEntity xiaoshouyuangongEntity = xiaoshouyuangongService.selectOne(queryWrapper);
        if(xiaoshouyuangongEntity != null)
            return R.error("账户或者销售员工手机号或者销售员工身份证号已经被使用");
        xiaoshouyuangong.setCreateTime(new Date());
        xiaoshouyuangongService.insert(xiaoshouyuangong);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        XiaoshouyuangongEntity xiaoshouyuangong = new XiaoshouyuangongEntity();
        xiaoshouyuangong.setPassword("123456");
        xiaoshouyuangong.setId(id);
        xiaoshouyuangongService.updateById(xiaoshouyuangong);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        XiaoshouyuangongEntity xiaoshouyuangong = xiaoshouyuangongService.selectOne(new EntityWrapper<XiaoshouyuangongEntity>().eq("username", username));
        if(xiaoshouyuangong!=null){
            xiaoshouyuangong.setPassword("123456");
            boolean b = xiaoshouyuangongService.updateById(xiaoshouyuangong);
            if(!b){
               return R.error();
            }
        }else{
           return R.error("账号不存在");
        }
        return R.ok();
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrXiaoshouyuangong(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        XiaoshouyuangongEntity xiaoshouyuangong = xiaoshouyuangongService.selectById(id);
        if(xiaoshouyuangong !=null){
            //entity转view
            XiaoshouyuangongView view = new XiaoshouyuangongView();
            BeanUtils.copyProperties( xiaoshouyuangong , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }





}
