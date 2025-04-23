package com.dao;

import com.entity.CaigoutuihuoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.CaigoutuihuoView;

/**
 * 采购退货 Dao 接口
 *
 * @author 
 */
public interface CaigoutuihuoDao extends BaseMapper<CaigoutuihuoEntity> {

   List<CaigoutuihuoView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
