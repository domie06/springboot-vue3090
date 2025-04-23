package com.entity.vo;

import com.entity.XiaoshouyuangongEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 销售员工
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("xiaoshouyuangong")
public class XiaoshouyuangongVO implements Serializable {
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
     * 工号
     */

    @TableField(value = "xiaoshouyuangong_uuid_number")
    private String xiaoshouyuangongUuidNumber;


    /**
     * 销售员工姓名
     */

    @TableField(value = "xiaoshouyuangong_name")
    private String xiaoshouyuangongName;


    /**
     * 销售员工手机号
     */

    @TableField(value = "xiaoshouyuangong_phone")
    private String xiaoshouyuangongPhone;


    /**
     * 销售员工身份证号
     */

    @TableField(value = "xiaoshouyuangong_id_number")
    private String xiaoshouyuangongIdNumber;


    /**
     * 销售员工头像
     */

    @TableField(value = "xiaoshouyuangong_photo")
    private String xiaoshouyuangongPhoto;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 电子邮箱
     */

    @TableField(value = "xiaoshouyuangong_email")
    private String xiaoshouyuangongEmail;


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
	 * 设置：工号
	 */
    public String getXiaoshouyuangongUuidNumber() {
        return xiaoshouyuangongUuidNumber;
    }


    /**
	 * 获取：工号
	 */

    public void setXiaoshouyuangongUuidNumber(String xiaoshouyuangongUuidNumber) {
        this.xiaoshouyuangongUuidNumber = xiaoshouyuangongUuidNumber;
    }
    /**
	 * 设置：销售员工姓名
	 */
    public String getXiaoshouyuangongName() {
        return xiaoshouyuangongName;
    }


    /**
	 * 获取：销售员工姓名
	 */

    public void setXiaoshouyuangongName(String xiaoshouyuangongName) {
        this.xiaoshouyuangongName = xiaoshouyuangongName;
    }
    /**
	 * 设置：销售员工手机号
	 */
    public String getXiaoshouyuangongPhone() {
        return xiaoshouyuangongPhone;
    }


    /**
	 * 获取：销售员工手机号
	 */

    public void setXiaoshouyuangongPhone(String xiaoshouyuangongPhone) {
        this.xiaoshouyuangongPhone = xiaoshouyuangongPhone;
    }
    /**
	 * 设置：销售员工身份证号
	 */
    public String getXiaoshouyuangongIdNumber() {
        return xiaoshouyuangongIdNumber;
    }


    /**
	 * 获取：销售员工身份证号
	 */

    public void setXiaoshouyuangongIdNumber(String xiaoshouyuangongIdNumber) {
        this.xiaoshouyuangongIdNumber = xiaoshouyuangongIdNumber;
    }
    /**
	 * 设置：销售员工头像
	 */
    public String getXiaoshouyuangongPhoto() {
        return xiaoshouyuangongPhoto;
    }


    /**
	 * 获取：销售员工头像
	 */

    public void setXiaoshouyuangongPhoto(String xiaoshouyuangongPhoto) {
        this.xiaoshouyuangongPhoto = xiaoshouyuangongPhoto;
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
    public String getXiaoshouyuangongEmail() {
        return xiaoshouyuangongEmail;
    }


    /**
	 * 获取：电子邮箱
	 */

    public void setXiaoshouyuangongEmail(String xiaoshouyuangongEmail) {
        this.xiaoshouyuangongEmail = xiaoshouyuangongEmail;
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
