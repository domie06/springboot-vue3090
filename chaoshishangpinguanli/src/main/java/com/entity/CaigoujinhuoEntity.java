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
 * 采购进货
 *
 * @author 
 * @email
 */
@TableName("caigoujinhuo")
public class CaigoujinhuoEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public CaigoujinhuoEntity() {

	}

	public CaigoujinhuoEntity(T t) {
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
     * 供应商
     */
    @TableField(value = "gongyingshang_id")

    private Integer gongyingshangId;


    /**
     * 采购员工
     */
    @TableField(value = "caigouyuangong_id")

    private Integer caigouyuangongId;


    /**
     * 进货单号
     */
    @TableField(value = "caigoujinhuo_uuid_number")

    private String caigoujinhuoUuidNumber;


    /**
     * 进货数量
     */
    @TableField(value = "caigoujinhuo_number")

    private Integer caigoujinhuoNumber;


    /**
     * 进货备注
     */
    @TableField(value = "caigoujinhuo_content")

    private String caigoujinhuoContent;


    /**
     * 进货时间
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
	 * 设置：供应商
	 */
    public Integer getGongyingshangId() {
        return gongyingshangId;
    }


    /**
	 * 获取：供应商
	 */

    public void setGongyingshangId(Integer gongyingshangId) {
        this.gongyingshangId = gongyingshangId;
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
	 * 设置：进货单号
	 */
    public String getCaigoujinhuoUuidNumber() {
        return caigoujinhuoUuidNumber;
    }


    /**
	 * 获取：进货单号
	 */

    public void setCaigoujinhuoUuidNumber(String caigoujinhuoUuidNumber) {
        this.caigoujinhuoUuidNumber = caigoujinhuoUuidNumber;
    }
    /**
	 * 设置：进货数量
	 */
    public Integer getCaigoujinhuoNumber() {
        return caigoujinhuoNumber;
    }


    /**
	 * 获取：进货数量
	 */

    public void setCaigoujinhuoNumber(Integer caigoujinhuoNumber) {
        this.caigoujinhuoNumber = caigoujinhuoNumber;
    }
    /**
	 * 设置：进货备注
	 */
    public String getCaigoujinhuoContent() {
        return caigoujinhuoContent;
    }


    /**
	 * 获取：进货备注
	 */

    public void setCaigoujinhuoContent(String caigoujinhuoContent) {
        this.caigoujinhuoContent = caigoujinhuoContent;
    }
    /**
	 * 设置：进货时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：进货时间
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
        return "Caigoujinhuo{" +
            "id=" + id +
            ", shangpinId=" + shangpinId +
            ", gongyingshangId=" + gongyingshangId +
            ", caigouyuangongId=" + caigouyuangongId +
            ", caigoujinhuoUuidNumber=" + caigoujinhuoUuidNumber +
            ", caigoujinhuoNumber=" + caigoujinhuoNumber +
            ", caigoujinhuoContent=" + caigoujinhuoContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
