package com.entity.model;

import com.entity.CaigoutuihuoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 采购退货
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class CaigoutuihuoModel implements Serializable {
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
     * 采购员工
     */
    private Integer caigouyuangongId;


    /**
     * 退货单号
     */
    private String caigoutuihuoUuidNumber;


    /**
     * 退货数量
     */
    private Integer caigoutuihuoNumber;


    /**
     * 退货备注
     */
    private String caigoutuihuoContent;


    /**
     * 退货时间
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
	 * 获取：采购员工
	 */
    public Integer getCaigouyuangongId() {
        return caigouyuangongId;
    }


    /**
	 * 设置：采购员工
	 */
    public void setCaigouyuangongId(Integer caigouyuangongId) {
        this.caigouyuangongId = caigouyuangongId;
    }
    /**
	 * 获取：退货单号
	 */
    public String getCaigoutuihuoUuidNumber() {
        return caigoutuihuoUuidNumber;
    }


    /**
	 * 设置：退货单号
	 */
    public void setCaigoutuihuoUuidNumber(String caigoutuihuoUuidNumber) {
        this.caigoutuihuoUuidNumber = caigoutuihuoUuidNumber;
    }
    /**
	 * 获取：退货数量
	 */
    public Integer getCaigoutuihuoNumber() {
        return caigoutuihuoNumber;
    }


    /**
	 * 设置：退货数量
	 */
    public void setCaigoutuihuoNumber(Integer caigoutuihuoNumber) {
        this.caigoutuihuoNumber = caigoutuihuoNumber;
    }
    /**
	 * 获取：退货备注
	 */
    public String getCaigoutuihuoContent() {
        return caigoutuihuoContent;
    }


    /**
	 * 设置：退货备注
	 */
    public void setCaigoutuihuoContent(String caigoutuihuoContent) {
        this.caigoutuihuoContent = caigoutuihuoContent;
    }
    /**
	 * 获取：退货时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：退货时间
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
