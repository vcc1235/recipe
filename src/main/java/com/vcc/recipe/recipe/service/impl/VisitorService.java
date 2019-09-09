package com.vcc.recipe.recipe.service.impl;
import javax.annotation.Resource;

import com.vcc.recipe.util.SecretUtil;
import org.springframework.stereotype.Service;
import com.vcc.recipe.common.AbstractService;
import com.vcc.recipe.common.IOperations;
import com.vcc.recipe.recipe.mapper.IVisitorMapper;
import com.vcc.recipe.recipe.domain.Visitor;
import com.vcc.recipe.recipe.service.IVisitorService;
/** 
* 
* @author 吴彬 的  autoWeb 自动代码 网址  www.wubin9.com 
* @data 2019年08月26日 16:09:38  
* 此文件由 www.wubin9.com 网站的自动代码 autoWeb 自动生成。 
* 可以根据需求随意修改，如果需要帮助，请联系 吴彬 
* 联系方式：QQ 810978593  微信  wubin0830bingo 邮箱 wubin5922@dingtalk.com 
*/  

@Service("visitorService")
public class VisitorService extends AbstractService<Visitor> implements IVisitorService {

	public VisitorService() {
		this.setTableName("visitor");
	}
	@Resource
	private IVisitorMapper visitorMapper;

	@Override
	protected IOperations<Visitor> getMapper() {
		return visitorMapper;
	}
	@Override
	public void setTableName(String tableName){
		this.tableName = tableName;
	}


	@Override
	public Visitor addVisitor(String device, String identifier) {

		Visitor visitor = new Visitor();
		long currentTimeMillis = System.currentTimeMillis();
		String name = "游客_"+currentTimeMillis%1000000;
		String idString = "VC"+currentTimeMillis+identifier ;
		visitor.setVisitorName( name );
		visitor.setVisitorId(SecretUtil.md5( idString ));
		visitor.setVisitorAvator( "http://www.baidu.com" );
		visitor.setVisitorSex( "m" );
		visitor.setVisitorDevice( device );
		visitor.setVisitorIdentifier( identifier );
		this.insert( visitor );
		return visitor;
	}
	
	
	
	
}

