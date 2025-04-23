
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
 * 采购员工
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/caigouyuangong")
public class CaigouyuangongController {
    private static final Logger logger = LoggerFactory.getLogger(CaigouyuangongController.class);

    @Autowired
    private CaigouyuangongService caigouyuangongService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private XiaoshouyuangongService xiaoshouyuangongService;


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
        PageUtils page = caigouyuangongService.queryPage(params);

        //字典表数据转换
        List<CaigouyuangongView> list =(List<CaigouyuangongView>)page.getList();
        for(CaigouyuangongView c:list){
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
        CaigouyuangongEntity caigouyuangong = caigouyuangongService.selectById(id);
        if(caigouyuangong !=null){
            //entity转view
            CaigouyuangongView view = new CaigouyuangongView();
            BeanUtils.copyProperties( caigouyuangong , view );//把实体数据重构到view中

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
    public R save(@RequestBody CaigouyuangongEntity caigouyuangong, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,caigouyuangong:{}",this.getClass().getName(),caigouyuangong.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<CaigouyuangongEntity> queryWrapper = new EntityWrapper<CaigouyuangongEntity>()
            .eq("username", caigouyuangong.getUsername())
            .or()
            .eq("caigouyuangong_phone", caigouyuangong.getCaigouyuangongPhone())
            .or()
            .eq("caigouyuangong_id_number", caigouyuangong.getCaigouyuangongIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        CaigouyuangongEntity caigouyuangongEntity = caigouyuangongService.selectOne(queryWrapper);
        if(caigouyuangongEntity==null){
            caigouyuangong.setCreateTime(new Date());
            caigouyuangong.setPassword("123456");
            caigouyuangongService.insert(caigouyuangong);
            return R.ok();
        }else {
            return R.error(511,"账户或者采购员工手机号或者采购员工身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody CaigouyuangongEntity caigouyuangong, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,caigouyuangong:{}",this.getClass().getName(),caigouyuangong.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<CaigouyuangongEntity> queryWrapper = new EntityWrapper<CaigouyuangongEntity>()
            .notIn("id",caigouyuangong.getId())
            .andNew()
            .eq("username", caigouyuangong.getUsername())
            .or()
            .eq("caigouyuangong_phone", caigouyuangong.getCaigouyuangongPhone())
            .or()
            .eq("caigouyuangong_id_number", caigouyuangong.getCaigouyuangongIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        CaigouyuangongEntity caigouyuangongEntity = caigouyuangongService.selectOne(queryWrapper);
        if("".equals(caigouyuangong.getCaigouyuangongPhoto()) || "null".equals(caigouyuangong.getCaigouyuangongPhoto())){
                caigouyuangong.setCaigouyuangongPhoto(null);
        }
        if(caigouyuangongEntity==null){
            caigouyuangongService.updateById(caigouyuangong);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者采购员工手机号或者采购员工身份证号已经被使用");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        caigouyuangongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<CaigouyuangongEntity> caigouyuangongList = new ArrayList<>();//上传的东西
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
                            CaigouyuangongEntity caigouyuangongEntity = new CaigouyuangongEntity();
//                            caigouyuangongEntity.setUsername(data.get(0));                    //账户 要改的
//                            //caigouyuangongEntity.setPassword("123456");//密码
//                            caigouyuangongEntity.setCaigouyuangongUuidNumber(data.get(0));                    //采购员工工号 要改的
//                            caigouyuangongEntity.setCaigouyuangongName(data.get(0));                    //采购员工姓名 要改的
//                            caigouyuangongEntity.setCaigouyuangongPhone(data.get(0));                    //采购员工手机号 要改的
//                            caigouyuangongEntity.setCaigouyuangongIdNumber(data.get(0));                    //采购员工身份证号 要改的
//                            caigouyuangongEntity.setCaigouyuangongPhoto("");//照片
//                            caigouyuangongEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            caigouyuangongEntity.setCaigouyuangongEmail(data.get(0));                    //电子邮箱 要改的
//                            caigouyuangongEntity.setCreateTime(date);//时间
                            caigouyuangongList.add(caigouyuangongEntity);


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
                                //采购员工工号
                                if(seachFields.containsKey("caigouyuangongUuidNumber")){
                                    List<String> caigouyuangongUuidNumber = seachFields.get("caigouyuangongUuidNumber");
                                    caigouyuangongUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> caigouyuangongUuidNumber = new ArrayList<>();
                                    caigouyuangongUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("caigouyuangongUuidNumber",caigouyuangongUuidNumber);
                                }
                                //采购员工手机号
                                if(seachFields.containsKey("caigouyuangongPhone")){
                                    List<String> caigouyuangongPhone = seachFields.get("caigouyuangongPhone");
                                    caigouyuangongPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> caigouyuangongPhone = new ArrayList<>();
                                    caigouyuangongPhone.add(data.get(0));//要改的
                                    seachFields.put("caigouyuangongPhone",caigouyuangongPhone);
                                }
                                //采购员工身份证号
                                if(seachFields.containsKey("caigouyuangongIdNumber")){
                                    List<String> caigouyuangongIdNumber = seachFields.get("caigouyuangongIdNumber");
                                    caigouyuangongIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> caigouyuangongIdNumber = new ArrayList<>();
                                    caigouyuangongIdNumber.add(data.get(0));//要改的
                                    seachFields.put("caigouyuangongIdNumber",caigouyuangongIdNumber);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<CaigouyuangongEntity> caigouyuangongEntities_username = caigouyuangongService.selectList(new EntityWrapper<CaigouyuangongEntity>().in("username", seachFields.get("username")));
                        if(caigouyuangongEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(CaigouyuangongEntity s:caigouyuangongEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //采购员工工号
                        List<CaigouyuangongEntity> caigouyuangongEntities_caigouyuangongUuidNumber = caigouyuangongService.selectList(new EntityWrapper<CaigouyuangongEntity>().in("caigouyuangong_uuid_number", seachFields.get("caigouyuangongUuidNumber")));
                        if(caigouyuangongEntities_caigouyuangongUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(CaigouyuangongEntity s:caigouyuangongEntities_caigouyuangongUuidNumber){
                                repeatFields.add(s.getCaigouyuangongUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [采购员工工号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //采购员工手机号
                        List<CaigouyuangongEntity> caigouyuangongEntities_caigouyuangongPhone = caigouyuangongService.selectList(new EntityWrapper<CaigouyuangongEntity>().in("caigouyuangong_phone", seachFields.get("caigouyuangongPhone")));
                        if(caigouyuangongEntities_caigouyuangongPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(CaigouyuangongEntity s:caigouyuangongEntities_caigouyuangongPhone){
                                repeatFields.add(s.getCaigouyuangongPhone());
                            }
                            return R.error(511,"数据库的该表中的 [采购员工手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //采购员工身份证号
                        List<CaigouyuangongEntity> caigouyuangongEntities_caigouyuangongIdNumber = caigouyuangongService.selectList(new EntityWrapper<CaigouyuangongEntity>().in("caigouyuangong_id_number", seachFields.get("caigouyuangongIdNumber")));
                        if(caigouyuangongEntities_caigouyuangongIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(CaigouyuangongEntity s:caigouyuangongEntities_caigouyuangongIdNumber){
                                repeatFields.add(s.getCaigouyuangongIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [采购员工身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        caigouyuangongService.insertBatch(caigouyuangongList);
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
        CaigouyuangongEntity caigouyuangong = caigouyuangongService.selectOne(new EntityWrapper<CaigouyuangongEntity>().eq("username", username));
        if(caigouyuangong==null || !caigouyuangong.getPassword().equals(password))
            return R.error("账号或密码不正确");
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(.getRoleTypes());
        String token = tokenService.generateToken(caigouyuangong.getId(),username, "caigouyuangong", "采购员工");
        R r = R.ok();
        r.put("token", token);
        r.put("role","采购员工");
        r.put("username",caigouyuangong.getCaigouyuangongName());
        r.put("tableName","caigouyuangong");
        r.put("userId",caigouyuangong.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody CaigouyuangongEntity caigouyuangong){
//    	ValidatorUtils.validateEntity(user);
        Wrapper<CaigouyuangongEntity> queryWrapper = new EntityWrapper<CaigouyuangongEntity>()
            .eq("username", caigouyuangong.getUsername())
            .or()
            .eq("caigouyuangong_phone", caigouyuangong.getCaigouyuangongPhone())
            .or()
            .eq("caigouyuangong_id_number", caigouyuangong.getCaigouyuangongIdNumber())
            ;
        CaigouyuangongEntity caigouyuangongEntity = caigouyuangongService.selectOne(queryWrapper);
        if(caigouyuangongEntity != null)
            return R.error("账户或者采购员工手机号或者采购员工身份证号已经被使用");
        caigouyuangong.setCreateTime(new Date());
        caigouyuangongService.insert(caigouyuangong);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        CaigouyuangongEntity caigouyuangong = new CaigouyuangongEntity();
        caigouyuangong.setPassword("123456");
        caigouyuangong.setId(id);
        caigouyuangongService.updateById(caigouyuangong);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        CaigouyuangongEntity caigouyuangong = caigouyuangongService.selectOne(new EntityWrapper<CaigouyuangongEntity>().eq("username", username));
        if(caigouyuangong!=null){
            caigouyuangong.setPassword("123456");
            boolean b = caigouyuangongService.updateById(caigouyuangong);
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
    public R getCurrCaigouyuangong(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        CaigouyuangongEntity caigouyuangong = caigouyuangongService.selectById(id);
        if(caigouyuangong !=null){
            //entity转view
            CaigouyuangongView view = new CaigouyuangongView();
            BeanUtils.copyProperties( caigouyuangong , view );//把实体数据重构到view中

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
