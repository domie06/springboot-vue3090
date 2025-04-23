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
 * 采购员工
 *
 * @author 
 * @email
 */
@TableName("caigouyuangong")
public class CaigouyuangongEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public CaigouyuangongEntity() {

	}

	public CaigouyuangongEntity(T t) {
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
     * 账户
     */
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @TableField(value = "password")

    private String password;


    /**
     * 采购员工工号
     */
    @TableField(value = "caigouyuangong_uuid_number")

    private String caigouyuangongUuidNumber;


    /**
     * 采购员工姓名
     */
    @TableField(value = "caigouyuangong_name")

    private String caigouyuangongName;


    /**
     * 采购员工手机号
     */
    @TableField(value = "caigouyuangong_phone")

    private String caigouyuangongPhone;


    /**
     * 采购员工身份证号
     */
    @TableField(value = "caigouyuangong_id_number")

    private String caigouyuangongIdNumber;


    /**
     * 采购员工头像
     */
    @TableField(value = "caigouyuangong_photo")

    private String caigouyuangongPhoto;


    /**
     * 性别
     */
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 电子邮箱
     */
    @TableField(value = "caigouyuangong_email")

    private String caigouyuangongEmail;


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
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：采购员工工号
	 */
    public String getCaigouyuangongUuidNumber() {
        return caigouyuangongUuidNumber;
    }


    /**
	 * 获取：采购员工工号
	 */

    public void setCaigouyuangongUuidNumber(String caigouyuangongUuidNumber) {
        this.caigouyuangongUuidNumber = caigouyuangongUuidNumber;
    }
    /**
	 * 设置：采购员工姓名
	 */
    public String getCaigouyuangongName() {
        return caigouyuangongName;
    }


    /**
	 * 获取：采购员工姓名
	 */

    public void setCaigouyuangongName(String caigouyuangongName) {
        this.caigouyuangongName = caigouyuangongName;
    }
    /**
	 * 设置：采购员工手机号
	 */
    public String getCaigouyuangongPhone() {
        return caigouyuangongPhone;
    }


    /**
	 * 获取：采购员工手机号
	 */

    public void setCaigouyuangongPhone(String caigouyuangongPhone) {
        this.caigouyuangongPhone = caigouyuangongPhone;
    }
    /**
	 * 设置：采购员工身份证号
	 */
    public String getCaigouyuangongIdNumber() {
        return caigouyuangongIdNumber;
    }


    /**
	 * 获取：采购员工身份证号
	 */

    public void setCaigouyuangongIdNumber(String caigouyuangongIdNumber) {
        this.caigouyuangongIdNumber = caigouyuangongIdNumber;
    }
    /**
	 * 设置：采购员工头像
	 */
    public String getCaigouyuangongPhoto() {
        return caigouyuangongPhoto;
    }


    /**
	 * 获取：采购员工头像
	 */

    public void setCaigouyuangongPhoto(String caigouyuangongPhoto) {
        this.caigouyuangongPhoto = caigouyuangongPhoto;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：电子邮箱
	 */
    public String getCaigouyuangongEmail() {
        return caigouyuangongEmail;
    }


    /**
	 * 获取：电子邮箱
	 */

    public void setCaigouyuangongEmail(String caigouyuangongEmail) {
        this.caigouyuangongEmail = caigouyuangongEmail;
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
        return "Caigouyuangong{" +
            "id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", caigouyuangongUuidNumber=" + caigouyuangongUuidNumber +
            ", caigouyuangongName=" + caigouyuangongName +
            ", caigouyuangongPhone=" + caigouyuangongPhone +
            ", caigouyuangongIdNumber=" + caigouyuangongIdNumber +
            ", caigouyuangongPhoto=" + caigouyuangongPhoto +
            ", sexTypes=" + sexTypes +
            ", caigouyuangongEmail=" + caigouyuangongEmail +
            ", createTime=" + createTime +
        "}";
    }
}
