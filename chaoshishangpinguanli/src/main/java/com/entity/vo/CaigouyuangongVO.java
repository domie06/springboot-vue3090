package com.entity.vo;

import com.entity.CaigouyuangongEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 采购员工
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("caigouyuangong")
public class CaigouyuangongVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "create_time")
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

}
