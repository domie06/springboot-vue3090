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
 * 采购退货
 *
 * @author 
 * @email
 */
@TableName("caigoutuihuo")
public class CaigoutuihuoEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public CaigoutuihuoEntity() {

	}

	public CaigoutuihuoEntity(T t) {
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
     * 商品
     */
    @TableField(value = "shangpin_id")

    private Integer shangpinId;


    /**
     * 采购员工
     */
    @TableField(value = "caigouyuangong_id")

    private Integer caigouyuangongId;


    /**
     * 退货单号
     */
    @TableField(value = "caigoutuihuo_uuid_number")

    private String caigoutuihuoUuidNumber;


    /**
     * 退货数量
     */
    @TableField(value = "caigoutuihuo_number")

    private Integer caigoutuihuoNumber;


    /**
     * 退货备注
     */
    @TableField(value = "caigoutuihuo_content")

    private String caigoutuihuoContent;


    /**
     * 退货时间
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
	 * 设置：商品
	 */
    public Integer getShangpinId() {
        return shangpinId;
    }


    /**
	 * 获取：商品
	 */

    public void setShangpinId(Integer shangpinId) {
        this.shangpinId = shangpinId;
    }
    /**
	 * 设置：采购员工
	 */
    public Integer getCaigouyuangongId() {
        return caigouyuangongId;
    }


    /**
	 * 获取：采购员工
	 */

    public void setCaigouyuangongId(Integer caigouyuangongId) {
        this.caigouyuangongId = caigouyuangongId;
    }
    /**
	 * 设置：退货单号
	 */
    public String getCaigoutuihuoUuidNumber() {
        return caigoutuihuoUuidNumber;
    }


    /**
	 * 获取：退货单号
	 */

    public void setCaigoutuihuoUuidNumber(String caigoutuihuoUuidNumber) {
        this.caigoutuihuoUuidNumber = caigoutuihuoUuidNumber;
    }
    /**
	 * 设置：退货数量
	 */
    public Integer getCaigoutuihuoNumber() {
        return caigoutuihuoNumber;
    }


    /**
	 * 获取：退货数量
	 */

    public void setCaigoutuihuoNumber(Integer caigoutuihuoNumber) {
        this.caigoutuihuoNumber = caigoutuihuoNumber;
    }
    /**
	 * 设置：退货备注
	 */
    public String getCaigoutuihuoContent() {
        return caigoutuihuoContent;
    }


    /**
	 * 获取：退货备注
	 */

    public void setCaigoutuihuoContent(String caigoutuihuoContent) {
        this.caigoutuihuoContent = caigoutuihuoContent;
    }
    /**
	 * 设置：退货时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：退货时间
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
        return "Caigoutuihuo{" +
            "id=" + id +
            ", shangpinId=" + shangpinId +
            ", caigouyuangongId=" + caigouyuangongId +
            ", caigoutuihuoUuidNumber=" + caigoutuihuoUuidNumber +
            ", caigoutuihuoNumber=" + caigoutuihuoNumber +
            ", caigoutuihuoContent=" + caigoutuihuoContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
