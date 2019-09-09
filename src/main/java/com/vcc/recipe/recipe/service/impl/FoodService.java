package com.vcc.recipe.recipe.service.impl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.vcc.recipe.common.AbstractService;
import com.vcc.recipe.common.IOperations;
import com.vcc.recipe.recipe.mapper.IFoodMapper;
import com.vcc.recipe.recipe.domain.Food;
import com.vcc.recipe.recipe.service.IFoodService;
/** 
* 
* @author 吴彬 的  autoWeb 自动代码 网址  www.wubin9.com 
* @data 2019年08月23日 22:53:10  
* 此文件由 www.wubin9.com 网站的自动代码 autoWeb 自动生成。 
* 可以根据需求随意修改，如果需要帮助，请联系 吴彬 
* 联系方式：QQ 810978593  微信  wubin0830bingo 邮箱 wubin5922@dingtalk.com 
*/  

@Service("foodService")
public class FoodService extends AbstractService<Food> implements IFoodService {

	public FoodService() {
		this.setTableName("food");
	}
	@Resource
	private IFoodMapper foodMapper;

	@Override
	protected IOperations<Food> getMapper() {
		return foodMapper;
	}
	@Override
	public void setTableName(String tableName){
		this.tableName = tableName;
	}
}

