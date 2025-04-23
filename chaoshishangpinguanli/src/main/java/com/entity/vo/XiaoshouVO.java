package com.entity.vo;

import com.entity.XiaoshouEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 商品销售
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("xiaoshou")
public class XiaoshouVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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
     * 备注
     */

    @TableField(value = "xiaoshou_content")
    private String xiaoshouContent;


    /**
     * 销售时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


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

}
