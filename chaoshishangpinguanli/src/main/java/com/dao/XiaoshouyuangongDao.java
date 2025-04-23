package com.dao;

import com.entity.XiaoshouyuangongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XiaoshouyuangongView;

/**
 * 销售员工 Dao 接口
 *
 * @author 
 */
public interface XiaoshouyuangongDao extends BaseMapper<XiaoshouyuangongEntity> {

   List<XiaoshouyuangongView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
