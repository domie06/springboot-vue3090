package com.dao;

import com.entity.CaigoujinhuoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.CaigoujinhuoView;

/**
 * 采购进货 Dao 接口
 *
 * @author 
 */
public interface CaigoujinhuoDao extends BaseMapper<CaigoujinhuoEntity> {

   List<CaigoujinhuoView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
