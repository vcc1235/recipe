package com.vcc.recipe.recipe.domain;
import java.math.BigDecimal;
import java.util.Date;
/** 
* 
* @author 吴彬 的  autoWeb 自动代码 网址  www.wubin9.com 
* @data 2019年08月26日 16:22:51  
* 此文件由 www.wubin9.com 网站的自动代码 autoWeb 自动生成。 
* 可以根据需求随意修改，如果需要帮助，请联系 吴彬 
* 联系方式：QQ 810978593  微信  wubin0830bingo 邮箱 wubin5922@dingtalk.com 
*/  

public class Visitor implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private String visitorId; // 
	private String visitorName; // 
	private String visitorAvator; // 
	private String visitorSex; // 
	private String visitorDevice; // 
	private String visitorIdentifier; // 
	private String createTime; // 创建时间
	private String updateTime; // 更新时间
	private String tbStatus; // 状态：正常，正常；删除，删除；

	public String getVisitorId() {
		return visitorId;
	}
	public void setVisitorId(String visitorId) {
		this.visitorId = visitorId;
	}

	public String getVisitorName() {
		return visitorName;
	}
	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}

	public String getVisitorAvator() {
		return visitorAvator;
	}
	public void setVisitorAvator(String visitorAvator) {
		this.visitorAvator = visitorAvator;
	}

	public String getVisitorSex() {
		return visitorSex;
	}
	public void setVisitorSex(String visitorSex) {
		this.visitorSex = visitorSex;
	}

	public String getVisitorDevice() {
		return visitorDevice;
	}
	public void setVisitorDevice(String visitorDevice) {
		this.visitorDevice = visitorDevice;
	}

	public String getVisitorIdentifier() {
		return visitorIdentifier;
	}
	public void setVisitorIdentifier(String visitorIdentifier) {
		this.visitorIdentifier = visitorIdentifier;
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

