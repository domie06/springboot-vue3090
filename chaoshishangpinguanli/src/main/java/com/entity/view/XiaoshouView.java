package com.entity.view;

import com.entity.XiaoshouEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 商品销售
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("xiaoshou")
public class XiaoshouView extends XiaoshouEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 shangpin
			/**
			* 商品编号
			*/
			private String shangpinUuidNumber;
			/**
			* 商品名称
			*/
			private String shangpinName;
			/**
			* 商品照片
			*/
			private String shangpinPhoto;
			/**
			* 商品类型
			*/
			private Integer shangpinTypes;
				/**
				* 商品类型的值
				*/
				private String shangpinValue;
			/**
			* 商品库存
			*/
			private Integer shangpinKucunNumber;
			/**
			* 单位
			*/
			private String shangpinDanwei;
			/**
			* 进价
			*/
			private Double shangpinJinjiaMoney;
			/**
			* 售价
			*/
			private Double shangpinShoujiaMoney;
			/**
			* 商品介绍
			*/
			private String shangpinContent;

		//级联表 xiaoshouyuangong
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
			* 电子邮箱
			*/
			private String xiaoshouyuangongEmail;

	public XiaoshouView() {

	}

	public XiaoshouView(XiaoshouEntity xiaoshouEntity) {
		try {
			BeanUtils.copyProperties(this, xiaoshouEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}






















				//级联表的get和set shangpin
					/**
					* 获取： 商品编号
					*/
					public String getShangpinUuidNumber() {
						return shangpinUuidNumber;
					}
					/**
					* 设置： 商品编号
					*/
					public void setShangpinUuidNumber(String shangpinUuidNumber) {
						this.shangpinUuidNumber = shangpinUuidNumber;
					}
					/**
					* 获取： 商品名称
					*/
					public String getShangpinName() {
						return shangpinName;
					}
					/**
					* 设置： 商品名称
					*/
					public void setShangpinName(String shangpinName) {
						this.shangpinName = shangpinName;
					}
					/**
					* 获取： 商品照片
					*/
					public String getShangpinPhoto() {
						return shangpinPhoto;
					}
					/**
					* 设置： 商品照片
					*/
					public void setShangpinPhoto(String shangpinPhoto) {
						this.shangpinPhoto = shangpinPhoto;
					}
					/**
					* 获取： 商品类型
					*/
					public Integer getShangpinTypes() {
						return shangpinTypes;
					}
					/**
					* 设置： 商品类型
					*/
					public void setShangpinTypes(Integer shangpinTypes) {
						this.shangpinTypes = shangpinTypes;
					}


						/**
						* 获取： 商品类型的值
						*/
						public String getShangpinValue() {
							return shangpinValue;
						}
						/**
						* 设置： 商品类型的值
						*/
						public void setShangpinValue(String shangpinValue) {
							this.shangpinValue = shangpinValue;
						}
					/**
					* 获取： 商品库存
					*/
					public Integer getShangpinKucunNumber() {
						return shangpinKucunNumber;
					}
					/**
					* 设置： 商品库存
					*/
					public void setShangpinKucunNumber(Integer shangpinKucunNumber) {
						this.shangpinKucunNumber = shangpinKucunNumber;
					}
					/**
					* 获取： 单位
					*/
					public String getShangpinDanwei() {
						return shangpinDanwei;
					}
					/**
					* 设置： 单位
					*/
					public void setShangpinDanwei(String shangpinDanwei) {
						this.shangpinDanwei = shangpinDanwei;
					}
					/**
					* 获取： 进价
					*/
					public Double getShangpinJinjiaMoney() {
						return shangpinJinjiaMoney;
					}
					/**
					* 设置： 进价
					*/
					public void setShangpinJinjiaMoney(Double shangpinJinjiaMoney) {
						this.shangpinJinjiaMoney = shangpinJinjiaMoney;
					}
					/**
					* 获取： 售价
					*/
					public Double getShangpinShoujiaMoney() {
						return shangpinShoujiaMoney;
					}
					/**
					* 设置： 售价
					*/
					public void setShangpinShoujiaMoney(Double shangpinShoujiaMoney) {
						this.shangpinShoujiaMoney = shangpinShoujiaMoney;
					}
					/**
					* 获取： 商品介绍
					*/
					public String getShangpinContent() {
						return shangpinContent;
					}
					/**
					* 设置： 商品介绍
					*/
					public void setShangpinContent(String shangpinContent) {
						this.shangpinContent = shangpinContent;
					}







				//级联表的get和set xiaoshouyuangong
					/**
					* 获取： 工号
					*/
					public String getXiaoshouyuangongUuidNumber() {
						return xiaoshouyuangongUuidNumber;
					}
					/**
					* 设置： 工号
					*/
					public void setXiaoshouyuangongUuidNumber(String xiaoshouyuangongUuidNumber) {
						this.xiaoshouyuangongUuidNumber = xiaoshouyuangongUuidNumber;
					}
					/**
					* 获取： 销售员工姓名
					*/
					public String getXiaoshouyuangongName() {
						return xiaoshouyuangongName;
					}
					/**
					* 设置： 销售员工姓名
					*/
					public void setXiaoshouyuangongName(String xiaoshouyuangongName) {
						this.xiaoshouyuangongName = xiaoshouyuangongName;
					}
					/**
					* 获取： 销售员工手机号
					*/
					public String getXiaoshouyuangongPhone() {
						return xiaoshouyuangongPhone;
					}
					/**
					* 设置： 销售员工手机号
					*/
					public void setXiaoshouyuangongPhone(String xiaoshouyuangongPhone) {
						this.xiaoshouyuangongPhone = xiaoshouyuangongPhone;
					}
					/**
					* 获取： 销售员工身份证号
					*/
					public String getXiaoshouyuangongIdNumber() {
						return xiaoshouyuangongIdNumber;
					}
					/**
					* 设置： 销售员工身份证号
					*/
					public void setXiaoshouyuangongIdNumber(String xiaoshouyuangongIdNumber) {
						this.xiaoshouyuangongIdNumber = xiaoshouyuangongIdNumber;
					}
					/**
					* 获取： 销售员工头像
					*/
					public String getXiaoshouyuangongPhoto() {
						return xiaoshouyuangongPhoto;
					}
					/**
					* 设置： 销售员工头像
					*/
					public void setXiaoshouyuangongPhoto(String xiaoshouyuangongPhoto) {
						this.xiaoshouyuangongPhoto = xiaoshouyuangongPhoto;
					}
					/**
					* 获取： 电子邮箱
					*/
					public String getXiaoshouyuangongEmail() {
						return xiaoshouyuangongEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setXiaoshouyuangongEmail(String xiaoshouyuangongEmail) {
						this.xiaoshouyuangongEmail = xiaoshouyuangongEmail;
					}



}
