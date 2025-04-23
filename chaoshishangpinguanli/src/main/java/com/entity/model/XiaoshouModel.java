package com.entity.model;

import com.entity.XiaoshouEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 商品销售
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XiaoshouModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 商品
     */
    private Integer shangpinId;


    /**
     * 销售员工
     */
    private Integer xiaoshouyuangongId;


    /**
     * 销售编号
     */
    private String xiaoshouUuidNumber;


    /**
     * 销售数量
     */
    private Integer xiaoshouKucunNumber;


    /**
     * 备注
     */
    private String xiaoshouContent;


    /**
     * 销售时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：商品
	 */
    public Integer getShangpinId() {
        return shangpinId;
    }


    /**
	 * 设置：商品
	 */
    public void setShangpinId(Integer shangpinId) {
        this.shangpinId = shangpinId;
    }
    /**
	 * 获取：销售员工
	 */
    public Integer getXiaoshouyuangongId() {
        return xiaoshouyuangongId;
    }


    /**
	 * 设置：销售员工
	 */
    public void setXiaoshouyuangongId(Integer xiaoshouyuangongId) {
        this.xiaoshouyuangongId = xiaoshouyuangongId;
    }
    /**
	 * 获取：销售编号
	 */
    public String getXiaoshouUuidNumber() {
        return xiaoshouUuidNumber;
    }


    /**
	 * 设置：销售编号
	 */
    public void setXiaoshouUuidNumber(String xiaoshouUuidNumber) {
        this.xiaoshouUuidNumber = xiaoshouUuidNumber;
    }
    /**
	 * 获取：销售数量
	 */
    public Integer getXiaoshouKucunNumber() {
        return xiaoshouKucunNumber;
    }


    /**
	 * 设置：销售数量
	 */
    public void setXiaoshouKucunNumber(Integer xiaoshouKucunNumber) {
        this.xiaoshouKucunNumber = xiaoshouKucunNumber;
    }
    /**
	 * 获取：备注
	 */
    public String getXiaoshouContent() {
        return xiaoshouContent;
    }


    /**
	 * 设置：备注
	 */
    public void setXiaoshouContent(String xiaoshouContent) {
        this.xiaoshouContent = xiaoshouContent;
    }
    /**
	 * 获取：销售时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：销售时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
