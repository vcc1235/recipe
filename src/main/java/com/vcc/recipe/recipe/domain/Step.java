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

public class Step implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer stepId; // 
	private Integer stepStep; // 步骤
	private String stepName; // 步骤标题
	private String stepImg; // 步骤图片
	private String footId; // 菜的id
	private String createTime; // 创建时间
	private String updateTime; // 更新时间
	private String tbStatus; // 状态：正常，正常；删除，删除；

	public Integer getStepId() {
		return stepId;
	}
	public void setStepId(Integer stepId) {
		this.stepId = stepId;
	}

	public Integer getStepStep() {
		return stepStep;
	}
	public void setStepStep(Integer stepStep) {
		this.stepStep = stepStep;
	}

	public String getStepName() {
		return stepName;
	}
	public void setStepName(String stepName) {
		this.stepName = stepName;
	}

	public String getStepImg() {
		return stepImg;
	}
	public void setStepImg(String stepImg) {
		this.stepImg = stepImg;
	}

	public String getFootId() {
		return footId;
	}
	public void setFootId(String footId) {
		this.footId = footId;
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

