package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 商品
 *
 * @author 
 * @email
 */
@TableName("shangpin")
public class ShangpinEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShangpinEntity() {

	}

	public ShangpinEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 商品编号
     */
    @TableField(value = "shangpin_uuid_number")

    private String shangpinUuidNumber;


    /**
     * 商品名称
     */
    @TableField(value = "shangpin_name")

    private String shangpinName;


    /**
     * 商品照片
     */
    @TableField(value = "shangpin_photo")

    private String shangpinPhoto;


    /**
     * 商品类型
     */
    @TableField(value = "shangpin_types")

    private Integer shangpinTypes;


    /**
     * 商品库存
     */
    @TableField(value = "shangpin_kucun_number")

    private Integer shangpinKucunNumber;


    /**
     * 单位
     */
    @TableField(value = "shangpin_danwei")

    private String shangpinDanwei;


    /**
     * 进价
     */
    @TableField(value = "shangpin_jinjia_money")

    private Double shangpinJinjiaMoney;


    /**
     * 售价
     */
    @TableField(value = "shangpin_shoujia_money")

    private Double shangpinShoujiaMoney;


    /**
     * 商品介绍
     */
    @TableField(value = "shangpin_content")

    private String shangpinContent;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：商品编号
	 */
    public String getShangpinUuidNumber() {
        return shangpinUuidNumber;
    }


    /**
	 * 获取：商品编号
	 */

    public void setShangpinUuidNumber(String shangpinUuidNumber) {
        this.shangpinUuidNumber = shangpinUuidNumber;
    }
    /**
	 * 设置：商品名称
	 */
    public String getShangpinName() {
        return shangpinName;
    }


    /**
	 * 获取：商品名称
	 */

    public void setShangpinName(String shangpinName) {
        this.shangpinName = shangpinName;
    }
    /**
	 * 设置：商品照片
	 */
    public String getShangpinPhoto() {
        return shangpinPhoto;
    }


    /**
	 * 获取：商品照片
	 */

    public void setShangpinPhoto(String shangpinPhoto) {
        this.shangpinPhoto = shangpinPhoto;
    }
    /**
	 * 设置：商品类型
	 */
    public Integer getShangpinTypes() {
        return shangpinTypes;
    }


    /**
	 * 获取：商品类型
	 */

    public void setShangpinTypes(Integer shangpinTypes) {
        this.shangpinTypes = shangpinTypes;
    }
    /**
	 * 设置：商品库存
	 */
    public Integer getShangpinKucunNumber() {
        return shangpinKucunNumber;
    }


    /**
	 * 获取：商品库存
	 */

    public void setShangpinKucunNumber(Integer shangpinKucunNumber) {
        this.shangpinKucunNumber = shangpinKucunNumber;
    }
    /**
	 * 设置：单位
	 */
    public String getShangpinDanwei() {
        return shangpinDanwei;
    }


    /**
	 * 获取：单位
	 */

    public void setShangpinDanwei(String shangpinDanwei) {
        this.shangpinDanwei = shangpinDanwei;
    }
    /**
	 * 设置：进价
	 */
    public Double getShangpinJinjiaMoney() {
        return shangpinJinjiaMoney;
    }


    /**
	 * 获取：进价
	 */

    public void setShangpinJinjiaMoney(Double shangpinJinjiaMoney) {
        this.shangpinJinjiaMoney = shangpinJinjiaMoney;
    }
    /**
	 * 设置：售价
	 */
    public Double getShangpinShoujiaMoney() {
        return shangpinShoujiaMoney;
    }


    /**
	 * 获取：售价
	 */

    public void setShangpinShoujiaMoney(Double shangpinShoujiaMoney) {
        this.shangpinShoujiaMoney = shangpinShoujiaMoney;
    }
    /**
	 * 设置：商品介绍
	 */
    public String getShangpinContent() {
        return shangpinContent;
    }


    /**
	 * 获取：商品介绍
	 */

    public void setShangpinContent(String shangpinContent) {
        this.shangpinContent = shangpinContent;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Shangpin{" +
            "id=" + id +
            ", shangpinUuidNumber=" + shangpinUuidNumber +
            ", shangpinName=" + shangpinName +
            ", shangpinPhoto=" + shangpinPhoto +
            ", shangpinTypes=" + shangpinTypes +
            ", shangpinKucunNumber=" + shangpinKucunNumber +
            ", shangpinDanwei=" + shangpinDanwei +
            ", shangpinJinjiaMoney=" + shangpinJinjiaMoney +
            ", shangpinShoujiaMoney=" + shangpinShoujiaMoney +
            ", shangpinContent=" + shangpinContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
