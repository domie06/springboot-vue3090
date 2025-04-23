
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
 * 采购进货
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/caigoujinhuo")
public class CaigoujinhuoController {
    private static final Logger logger = LoggerFactory.getLogger(CaigoujinhuoController.class);

    @Autowired
    private CaigoujinhuoService caigoujinhuoService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private CaigouyuangongService caigouyuangongService;
    @Autowired
    private GongyingshangService gongyingshangService;
    @Autowired
    private ShangpinService shangpinService;

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
        PageUtils page = caigoujinhuoService.queryPage(params);

        //字典表数据转换
        List<CaigoujinhuoView> list =(List<CaigoujinhuoView>)page.getList();
        for(CaigoujinhuoView c:list){
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
        CaigoujinhuoEntity caigoujinhuo = caigoujinhuoService.selectById(id);
        if(caigoujinhuo !=null){
            //entity转view
            CaigoujinhuoView view = new CaigoujinhuoView();
            BeanUtils.copyProperties( caigoujinhuo , view );//把实体数据重构到view中

                //级联表
                CaigouyuangongEntity caigouyuangong = caigouyuangongService.selectById(caigoujinhuo.getCaigouyuangongId());
                if(caigouyuangong != null){
                    BeanUtils.copyProperties( caigouyuangong , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setCaigouyuangongId(caigouyuangong.getId());
                }
                //级联表
                GongyingshangEntity gongyingshang = gongyingshangService.selectById(caigoujinhuo.getGongyingshangId());
                if(gongyingshang != null){
                    BeanUtils.copyProperties( gongyingshang , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setGongyingshangId(gongyingshang.getId());
                }
                //级联表
                ShangpinEntity shangpin = shangpinService.selectById(caigoujinhuo.getShangpinId());
                if(shangpin != null){
                    BeanUtils.copyProperties( shangpin , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setShangpinId(shangpin.getId());
                }
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
    public R save(@RequestBody CaigoujinhuoEntity caigoujinhuo, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,caigoujinhuo:{}",this.getClass().getName(),caigoujinhuo.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("采购员工".equals(role))
            caigoujinhuo.setCaigouyuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));


        ShangpinEntity shangpinEntity = shangpinService.selectById(caigoujinhuo.getShangpinId());
        if(shangpinEntity == null){
            return  R.error("查不到该商品");
        }
        shangpinEntity.setShangpinKucunNumber(shangpinEntity.getShangpinKucunNumber()+caigoujinhuo.getCaigoujinhuoNumber());
        shangpinService.updateById(shangpinEntity);


            caigoujinhuo.setInsertTime(new Date());
            caigoujinhuo.setCreateTime(new Date());
            caigoujinhuoService.insert(caigoujinhuo);
            return R.ok();

    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody CaigoujinhuoEntity caigoujinhuo, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,caigoujinhuo:{}",this.getClass().getName(),caigoujinhuo.toString());

            caigoujinhuoService.updateById(caigoujinhuo);//根据id更新
            return R.ok();

    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        caigoujinhuoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<CaigoujinhuoEntity> caigoujinhuoList = new ArrayList<>();//上传的东西
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
                            CaigoujinhuoEntity caigoujinhuoEntity = new CaigoujinhuoEntity();
//                            caigoujinhuoEntity.setShangpinId(Integer.valueOf(data.get(0)));   //商品 要改的
//                            caigoujinhuoEntity.setGongyingshangId(Integer.valueOf(data.get(0)));   //供应商 要改的
//                            caigoujinhuoEntity.setCaigouyuangongId(Integer.valueOf(data.get(0)));   //采购员工 要改的
//                            caigoujinhuoEntity.setCaigoujinhuoUuidNumber(data.get(0));                    //进货单号 要改的
//                            caigoujinhuoEntity.setCaigoujinhuoNumber(Integer.valueOf(data.get(0)));   //进货数量 要改的
//                            caigoujinhuoEntity.setCaigoujinhuoContent("");//照片
//                            caigoujinhuoEntity.setInsertTime(date);//时间
//                            caigoujinhuoEntity.setCreateTime(date);//时间
                            caigoujinhuoList.add(caigoujinhuoEntity);


                            //把要查询是否重复的字段放入map中
                                //进货单号
                                if(seachFields.containsKey("caigoujinhuoUuidNumber")){
                                    List<String> caigoujinhuoUuidNumber = seachFields.get("caigoujinhuoUuidNumber");
                                    caigoujinhuoUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> caigoujinhuoUuidNumber = new ArrayList<>();
                                    caigoujinhuoUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("caigoujinhuoUuidNumber",caigoujinhuoUuidNumber);
                                }
                        }

                        //查询是否重复
                         //进货单号
                        List<CaigoujinhuoEntity> caigoujinhuoEntities_caigoujinhuoUuidNumber = caigoujinhuoService.selectList(new EntityWrapper<CaigoujinhuoEntity>().in("caigoujinhuo_uuid_number", seachFields.get("caigoujinhuoUuidNumber")));
                        if(caigoujinhuoEntities_caigoujinhuoUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(CaigoujinhuoEntity s:caigoujinhuoEntities_caigoujinhuoUuidNumber){
                                repeatFields.add(s.getCaigoujinhuoUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [进货单号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        caigoujinhuoService.insertBatch(caigoujinhuoList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
