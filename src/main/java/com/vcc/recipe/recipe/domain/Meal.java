package com.vcc.recipe.recipe.domain;
import java.math.BigDecimal;
import java.util.Date;
/** 
* 
* @author 吴彬 的  autoWeb 自动代码 网址  www.wubin9.com 
* @data 2019年08月23日 22:53:10  
* 此文件由 www.wubin9.com 网站的自动代码 autoWeb 自动生成。 
* 可以根据需求随意修改，如果需要帮助，请联系 吴彬 
* 联系方式：QQ 810978593  微信  wubin0830bingo 邮箱 wubin5922@dingtalk.com 
*/  

public class Meal implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer mealId; // 
	private String mealName; // 菜单名
	private String mealType; // 菜单
	private String createTime; // 创建时间
	private String updateTime; // 更新时间
	private String tbStatus; // 状态：正常，正常；删除，删除；

	public Integer getMealId() {
		return mealId;
	}
	public void setMealId(Integer mealId) {
		this.mealId = mealId;
	}

	public String getMealName() {
		return mealName;
	}
	public void setMealName(String mealName) {
		this.mealName = mealName;
	}

	public String getMealType() {
		return mealType;
	}
	public void setMealType(String mealType) {
		this.mealType = mealType;
	}

	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getTbStatus() {
		return tbStatus;
	}
	public void setTbStatus(String tbStatus) {
		this.tbStatus = tbStatus;
	}

}

