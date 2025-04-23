package com.entity.model;

import com.entity.CaigoujinhuoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 采购进货
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class CaigoujinhuoModel implements Serializable {
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
     * 供应商
     */
    private Integer gongyingshangId;


    /**
     * 采购员工
     */
    private Integer caigouyuangongId;


    /**
     * 进货单号
     */
    private String caigoujinhuoUuidNumber;


    /**
     * 进货数量
     */
    private Integer caigoujinhuoNumber;


    /**
     * 进货备注
     */
    private String caigoujinhuoContent;


    /**
     * 进货时间
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
	 * 获取：供应商
	 */
    public Integer getGongyingshangId() {
        return gongyingshangId;
    }


    /**
	 * 设置：供应商
	 */
    public void setGongyingshangId(Integer gongyingshangId) {
        this.gongyingshangId = gongyingshangId;
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
	 * 获取：进货单号
	 */
    public String getCaigoujinhuoUuidNumber() {
        return caigoujinhuoUuidNumber;
    }


    /**
	 * 设置：进货单号
	 */
    public void setCaigoujinhuoUuidNumber(String caigoujinhuoUuidNumber) {
        this.caigoujinhuoUuidNumber = caigoujinhuoUuidNumber;
    }
    /**
	 * 获取：进货数量
	 */
    public Integer getCaigoujinhuoNumber() {
        return caigoujinhuoNumber;
    }


    /**
	 * 设置：进货数量
	 */
    public void setCaigoujinhuoNumber(Integer caigoujinhuoNumber) {
        this.caigoujinhuoNumber = caigoujinhuoNumber;
    }
    /**
	 * 获取：进货备注
	 */
    public String getCaigoujinhuoContent() {
        return caigoujinhuoContent;
    }


    /**
	 * 设置：进货备注
	 */
    public void setCaigoujinhuoContent(String caigoujinhuoContent) {
        this.caigoujinhuoContent = caigoujinhuoContent;
    }
    /**
	 * 获取：进货时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：进货时间
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
