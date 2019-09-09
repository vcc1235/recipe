package com.vcc.recipe.recipe.service.impl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.vcc.recipe.common.AbstractService;
import com.vcc.recipe.common.IOperations;
import com.vcc.recipe.recipe.mapper.IStepMapper;
import com.vcc.recipe.recipe.domain.Step;
import com.vcc.recipe.recipe.service.IStepService;
/** 
* 
* @author 吴彬 的  autoWeb 自动代码 网址  www.wubin9.com 
* @data 2019年08月23日 22:53:10  
* 此文件由 www.wubin9.com 网站的自动代码 autoWeb 自动生成。 
* 可以根据需求随意修改，如果需要帮助，请联系 吴彬 
* 联系方式：QQ 810978593  微信  wubin0830bingo 邮箱 wubin5922@dingtalk.com 
*/  

@Service("stepService")
public class StepService extends AbstractService<Step> implements IStepService {

	public StepService() {
		this.setTableName("step");
	}
	@Resource
	private IStepMapper stepMapper;

	@Override
	protected IOperations<Step> getMapper() {
		return stepMapper;
	}
	@Override
	public void setTableName(String tableName){
		this.tableName = tableName;
	}
}

