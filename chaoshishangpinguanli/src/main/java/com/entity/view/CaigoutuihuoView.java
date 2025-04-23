package com.entity.view;

import com.entity.CaigoutuihuoEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 采购退货
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("caigoutuihuo")
public class CaigoutuihuoView extends CaigoutuihuoEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 caigouyuangong
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
			* 电子邮箱
			*/
			private String caigouyuangongEmail;

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

	public CaigoutuihuoView() {

	}

	public CaigoutuihuoView(CaigoutuihuoEntity caigoutuihuoEntity) {
		try {
			BeanUtils.copyProperties(this, caigoutuihuoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}














				//级联表的get和set caigouyuangong
					/**
					* 获取： 采购员工工号
					*/
					public String getCaigouyuangongUuidNumber() {
						return caigouyuangongUuidNumber;
					}
					/**
					* 设置： 采购员工工号
					*/
					public void setCaigouyuangongUuidNumber(String caigouyuangongUuidNumber) {
						this.caigouyuangongUuidNumber = caigouyuangongUuidNumber;
					}
					/**
					* 获取： 采购员工姓名
					*/
					public String getCaigouyuangongName() {
						return caigouyuangongName;
					}
					/**
					* 设置： 采购员工姓名
					*/
					public void setCaigouyuangongName(String caigouyuangongName) {
						this.caigouyuangongName = caigouyuangongName;
					}
					/**
					* 获取： 采购员工手机号
					*/
					public String getCaigouyuangongPhone() {
						return caigouyuangongPhone;
					}
					/**
					* 设置： 采购员工手机号
					*/
					public void setCaigouyuangongPhone(String caigouyuangongPhone) {
						this.caigouyuangongPhone = caigouyuangongPhone;
					}
					/**
					* 获取： 采购员工身份证号
					*/
					public String getCaigouyuangongIdNumber() {
						return caigouyuangongIdNumber;
					}
					/**
					* 设置： 采购员工身份证号
					*/
					public void setCaigouyuangongIdNumber(String caigouyuangongIdNumber) {
						this.caigouyuangongIdNumber = caigouyuangongIdNumber;
					}
					/**
					* 获取： 采购员工头像
					*/
					public String getCaigouyuangongPhoto() {
						return caigouyuangongPhoto;
					}
					/**
					* 设置： 采购员工头像
					*/
					public void setCaigouyuangongPhoto(String caigouyuangongPhoto) {
						this.caigouyuangongPhoto = caigouyuangongPhoto;
					}
					/**
					* 获取： 电子邮箱
					*/
					public String getCaigouyuangongEmail() {
						return caigouyuangongEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setCaigouyuangongEmail(String caigouyuangongEmail) {
						this.caigouyuangongEmail = caigouyuangongEmail;
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










}
