package com.entity.model;

import com.entity.XiaoshouyuangongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 销售员工
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XiaoshouyuangongModel implements Serializable {
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
     * 工号
     */
    private String xiaoshouyuangongUuidNumber;


    /**
     * 销售员工姓名
     */
    private String xiaoshouyuangongName;


    /**
     * 销售员工手机号
     */
    private String xiaoshouyuangongPhone;


    /**
     * 销售员工身份证号
     */
    private String xiaoshouyuangongIdNumber;


    /**
     * 销售员工头像
     */
    private String xiaoshouyuangongPhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 电子邮箱
     */
    private String xiaoshouyuangongEmail;


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
	 * 获取：工号
	 */
    public String getXiaoshouyuangongUuidNumber() {
        return xiaoshouyuangongUuidNumber;
    }


    /**
	 * 设置：工号
	 */
    public void setXiaoshouyuangongUuidNumber(String xiaoshouyuangongUuidNumber) {
        this.xiaoshouyuangongUuidNumber = xiaoshouyuangongUuidNumber;
    }
    /**
	 * 获取：销售员工姓名
	 */
    public String getXiaoshouyuangongName() {
        return xiaoshouyuangongName;
    }


    /**
	 * 设置：销售员工姓名
	 */
    public void setXiaoshouyuangongName(String xiaoshouyuangongName) {
        this.xiaoshouyuangongName = xiaoshouyuangongName;
    }
    /**
	 * 获取：销售员工手机号
	 */
    public String getXiaoshouyuangongPhone() {
        return xiaoshouyuangongPhone;
    }


    /**
	 * 设置：销售员工手机号
	 */
    public void setXiaoshouyuangongPhone(String xiaoshouyuangongPhone) {
        this.xiaoshouyuangongPhone = xiaoshouyuangongPhone;
    }
    /**
	 * 获取：销售员工身份证号
	 */
    public String getXiaoshouyuangongIdNumber() {
        return xiaoshouyuangongIdNumber;
    }


    /**
	 * 设置：销售员工身份证号
	 */
    public void setXiaoshouyuangongIdNumber(String xiaoshouyuangongIdNumber) {
        this.xiaoshouyuangongIdNumber = xiaoshouyuangongIdNumber;
    }
    /**
	 * 获取：销售员工头像
	 */
    public String getXiaoshouyuangongPhoto() {
        return xiaoshouyuangongPhoto;
    }


    /**
	 * 设置：销售员工头像
	 */
    public void setXiaoshouyuangongPhoto(String xiaoshouyuangongPhoto) {
        this.xiaoshouyuangongPhoto = xiaoshouyuangongPhoto;
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
    public String getXiaoshouyuangongEmail() {
        return xiaoshouyuangongEmail;
    }


    /**
	 * 设置：电子邮箱
	 */
    public void setXiaoshouyuangongEmail(String xiaoshouyuangongEmail) {
        this.xiaoshouyuangongEmail = xiaoshouyuangongEmail;
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
