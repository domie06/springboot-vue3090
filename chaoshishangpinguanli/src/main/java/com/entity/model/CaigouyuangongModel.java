package com.entity.model;

import com.entity.CaigouyuangongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 采购员工
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class CaigouyuangongModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 采购员工工号
     */
    private String caigouyuangongUuidNumber;


    /**
     * 采购员工姓名
     */
    private String caigouyuangongName;


    /**
     * 采购员工手机号
     */
    private String caigouyuangongPhone;


    /**
     * 采购员工身份证号
     */
    private String caigouyuangongIdNumber;


    /**
     * 采购员工头像
     */
    private String caigouyuangongPhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 电子邮箱
     */
    private String caigouyuangongEmail;


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
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：采购员工工号
	 */
    public String getCaigouyuangongUuidNumber() {
        return caigouyuangongUuidNumber;
    }


    /**
	 * 设置：采购员工工号
	 */
    public void setCaigouyuangongUuidNumber(String caigouyuangongUuidNumber) {
        this.caigouyuangongUuidNumber = caigouyuangongUuidNumber;
    }
    /**
	 * 获取：采购员工姓名
	 */
    public String getCaigouyuangongName() {
        return caigouyuangongName;
    }


    /**
	 * 设置：采购员工姓名
	 */
    public void setCaigouyuangongName(String caigouyuangongName) {
        this.caigouyuangongName = caigouyuangongName;
    }
    /**
	 * 获取：采购员工手机号
	 */
    public String getCaigouyuangongPhone() {
        return caigouyuangongPhone;
    }


    /**
	 * 设置：采购员工手机号
	 */
    public void setCaigouyuangongPhone(String caigouyuangongPhone) {
        this.caigouyuangongPhone = caigouyuangongPhone;
    }
    /**
	 * 获取：采购员工身份证号
	 */
    public String getCaigouyuangongIdNumber() {
        return caigouyuangongIdNumber;
    }


    /**
	 * 设置：采购员工身份证号
	 */
    public void setCaigouyuangongIdNumber(String caigouyuangongIdNumber) {
        this.caigouyuangongIdNumber = caigouyuangongIdNumber;
    }
    /**
	 * 获取：采购员工头像
	 */
    public String getCaigouyuangongPhoto() {
        return caigouyuangongPhoto;
    }


    /**
	 * 设置：采购员工头像
	 */
    public void setCaigouyuangongPhoto(String caigouyuangongPhoto) {
        this.caigouyuangongPhoto = caigouyuangongPhoto;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：电子邮箱
	 */
    public String getCaigouyuangongEmail() {
        return caigouyuangongEmail;
    }


    /**
	 * 设置：电子邮箱
	 */
    public void setCaigouyuangongEmail(String caigouyuangongEmail) {
        this.caigouyuangongEmail = caigouyuangongEmail;
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
