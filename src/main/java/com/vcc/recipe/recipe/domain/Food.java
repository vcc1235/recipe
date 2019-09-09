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

public class Food implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private String foodId; // 
	private String foodName; // 菜名
	private String foodImg; // 菜图片
	private String foodDec; // 菜描述
	private String foodList; // 材料列表
	private Integer footNum; // 浏览量
	private String createTime; // 创建时间
	private String updateTime; // 更新时间
	private String tbStatus; // 状态：正常，正常；删除，删除；
	private String foodStep; // 

	public String getFoodId() {
		return foodId;
	}
	public void setFoodId(String foodId) {
		this.foodId = foodId;
	}

	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getFoodImg() {
		return foodImg;
	}
	public void setFoodImg(String foodImg) {
		this.foodImg = foodImg;
	}

	public String getFoodDec() {
		return foodDec;
	}
	public void setFoodDec(String foodDec) {
		this.foodDec = foodDec;
	}

	public String getFoodList() {
		return foodList;
	}
	public void setFoodList(String foodList) {
		this.foodList = foodList;
	}

	public Integer getFootNum() {
		return footNum;
	}
	public void setFootNum(Integer footNum) {
		this.footNum = footNum;
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

	public String getFoodStep() {
		return foodStep;
	}
	public void setFoodStep(String foodStep) {
		this.foodStep = foodStep;
	}

}

