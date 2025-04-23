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
 * 商品销售
 *
 * @author 
 * @email
 */
@TableName("xiaoshou")
public class XiaoshouEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XiaoshouEntity() {

	}

	public XiaoshouEntity(T t) {
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
     * 销售员工
     */
    @TableField(value = "xiaoshouyuangong_id")

    private Integer xiaoshouyuangongId;


    /**
     * 销售编号
     */
    @TableField(value = "xiaoshou_uuid_number")

    private String xiaoshouUuidNumber;


    /**
     * 销售数量
     */
    @TableField(value = "xiaoshou_kucun_number")

    private Integer xiaoshouKucunNumber;


    /**
     * 总成本
     */
    @TableField(value = "xiaoshou_zongchengben_money")

    private Double xiaoshouZongchengbenMoney;


    /**
     * 总售价
     */
    @TableField(value = "xiaoshou_zongshoujia_money")

    private Double xiaoshouZongshoujiaMoney;


    /**
     * 总利润
     */
    @TableField(value = "xiaoshou_zonglirun_money")

    private Double xiaoshouZonglirunMoney;


    /**
     * 备注
     */
    @TableField(value = "xiaoshou_content")

    private String xiaoshouContent;


    /**
     * 销售时间
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
	 * 设置：销售员工
	 */
    public Integer getXiaoshouyuangongId() {
        return xiaoshouyuangongId;
    }


    /**
	 * 获取：销售员工
	 */

    public void setXiaoshouyuangongId(Integer xiaoshouyuangongId) {
        this.xiaoshouyuangongId = xiaoshouyuangongId;
    }
    /**
	 * 设置：销售编号
	 */
    public String getXiaoshouUuidNumber() {
        return xiaoshouUuidNumber;
    }


    /**
	 * 获取：销售编号
	 */

    public void setXiaoshouUuidNumber(String xiaoshouUuidNumber) {
        this.xiaoshouUuidNumber = xiaoshouUuidNumber;
    }
    /**
	 * 设置：销售数量
	 */
    public Integer getXiaoshouKucunNumber() {
        return xiaoshouKucunNumber;
    }


    /**
	 * 获取：销售数量
	 */

    public void setXiaoshouKucunNumber(Integer xiaoshouKucunNumber) {
        this.xiaoshouKucunNumber = xiaoshouKucunNumber;
    }
    /**
	 * 设置：总成本
	 */
    public Double getXiaoshouZongchengbenMoney() {
        return xiaoshouZongchengbenMoney;
    }


    /**
	 * 获取：总成本
	 */

    public void setXiaoshouZongchengbenMoney(Double xiaoshouZongchengbenMoney) {
        this.xiaoshouZongchengbenMoney = xiaoshouZongchengbenMoney;
    }
    /**
	 * 设置：总售价
	 */
    public Double getXiaoshouZongshoujiaMoney() {
        return xiaoshouZongshoujiaMoney;
    }


    /**
	 * 获取：总售价
	 */

    public void setXiaoshouZongshoujiaMoney(Double xiaoshouZongshoujiaMoney) {
        this.xiaoshouZongshoujiaMoney = xiaoshouZongshoujiaMoney;
    }
    /**
	 * 设置：总利润
	 */
    public Double getXiaoshouZonglirunMoney() {
        return xiaoshouZonglirunMoney;
    }


    /**
	 * 获取：总利润
	 */

    public void setXiaoshouZonglirunMoney(Double xiaoshouZonglirunMoney) {
        this.xiaoshouZonglirunMoney = xiaoshouZonglirunMoney;
    }
    /**
	 * 设置：备注
	 */
    public String getXiaoshouContent() {
        return xiaoshouContent;
    }


    /**
	 * 获取：备注
	 */

    public void setXiaoshouContent(String xiaoshouContent) {
        this.xiaoshouContent = xiaoshouContent;
    }
    /**
	 * 设置：销售时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：销售时间
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
        return "Xiaoshou{" +
            "id=" + id +
            ", shangpinId=" + shangpinId +
            ", xiaoshouyuangongId=" + xiaoshouyuangongId +
            ", xiaoshouUuidNumber=" + xiaoshouUuidNumber +
            ", xiaoshouKucunNumber=" + xiaoshouKucunNumber +
            ", xiaoshouZongchengbenMoney=" + xiaoshouZongchengbenMoney +
            ", xiaoshouZongshoujiaMoney=" + xiaoshouZongshoujiaMoney +
            ", xiaoshouZonglirunMoney=" + xiaoshouZonglirunMoney +
            ", xiaoshouContent=" + xiaoshouContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
