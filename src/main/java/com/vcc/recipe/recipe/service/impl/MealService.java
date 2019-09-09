package com.vcc.recipe.recipe.service.impl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.vcc.recipe.common.AbstractService;
import com.vcc.recipe.common.IOperations;
import com.vcc.recipe.recipe.mapper.IMealMapper;
import com.vcc.recipe.recipe.domain.Meal;
import com.vcc.recipe.recipe.service.IMealService;
import com.vcc.recipe.config.RecipyConfig;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/** 
* 
* @author 吴彬 的  autoWeb 自动代码 网址  www.wubin9.com 
* @data 2019年08月23日 22:53:10  
* 此文件由 www.wubin9.com 网站的自动代码 autoWeb 自动生成。 
* 可以根据需求随意修改，如果需要帮助，请联系 吴彬 
* 联系方式：QQ 810978593  微信  wubin0830bingo 邮箱 wubin5922@dingtalk.com 
*/  

@Service("mealService")
public class MealService extends AbstractService<Meal> implements IMealService {

	public MealService() {
		this.setTableName("meal");
	}
	@Resource
	private IMealMapper mealMapper;

	@Override
	protected IOperations<Meal> getMapper() {
		return mealMapper;
	}
	@Override
	public void setTableName(String tableName){
		this.tableName = tableName;
		
	}

	@Override
	public List<Meal> getMealList(Integer page, Integer pageSize) {
		LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
		linkedHashMap.put( RecipyConfig.TB_STATUS+"='"+RecipyConfig.TB_NORMAL+"'","");
		List<Meal> mealList = this.getList( linkedHashMap, page, pageSize );
		return mealList;
	}

	@Override
	public Integer getMealCount() {
		LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
		linkedHashMap.put( RecipyConfig.TB_STATUS+"='"+RecipyConfig.TB_NORMAL+"'","");
		int count = this.getCount( linkedHashMap, null );
		return count;
	}

	@Override
	public int addMeal(String name, String type) {
		
		LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
		linkedHashMap.put( RecipyConfig.TB_STATUS+"='"+RecipyConfig.TB_NORMAL+"'","");
		linkedHashMap.put( "meal_name = '"+name+"'"," and " );
		linkedHashMap.put( "meal_type = '"+type+"'"," and " );
		Meal one = this.getOne( linkedHashMap );
		if (one != null){
			return 0 ;
		}
		Meal meal = new Meal();
		meal.setMealName( name );
		meal.setMealType( type );
		this.insert( meal );
		if (meal.getMealId()>0){
			return 1 ;
		}else {
			return -1 ;
		}
		
	}


	@Override
	public Meal getOneMeal(int mealId) {
		
		LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
		linkedHashMap.put( RecipyConfig.TB_STATUS+"='"+RecipyConfig.TB_NORMAL+"'","");
		linkedHashMap.put( "meal_id = '"+mealId+"'"," and ");
		Meal meal = this.getOne( linkedHashMap );
		return meal ;
		
	}

	@Override
	public int updateMeal(int mealId, String name, String type) {

		LinkedHashMap<String, String> hashMap = new LinkedHashMap<>();
		hashMap.put( "meal_id = '"+mealId+"'","");
		hashMap.put( RecipyConfig.TB_STATUS+"='"+RecipyConfig.TB_NORMAL+"'"," and ");
		Meal meal = this.getOne( hashMap );
		if (meal == null){  /// 不存在这个分类
			return 0 ;
		}
		meal.setMealType( type );
		meal.setMealName( name );
		List<Meal> mealList = new ArrayList<>(  );
		mealList.add( meal );
		return this.update( mealList ); /// 更新
		
	}

	@Override
	public int deleteMeal(int mealId) {
		LinkedHashMap<String, String> hashMap = new LinkedHashMap<>();
		hashMap.put( "meal_id = '"+mealId+"'","");
		Meal meal = this.getOne( hashMap );
		if (meal == null){  /// 不存在这个分类
			return 0 ;
		}
		meal.setTbStatus( RecipyConfig.TB_DELETE );
		List<Meal> list = new ArrayList<>();
		list.add( meal );
		return this.update( list );
		
	}


	@Override
	public List<Meal> searchMealList(String keyword) {
		LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
		linkedHashMap.put( RecipyConfig.TB_STATUS+"='"+RecipyConfig.TB_NORMAL+"'","");
		linkedHashMap.put( "meal_type like '%"+keyword+"%'","and (");
		linkedHashMap.put( "meal_name like '%"+keyword+"%')","or");
		List<Meal> mealList = this.getAllList( linkedHashMap );
		return mealList ;
	}


	
	/************************************* Api  ************************************/

	@Override
	public List<Meal> getMealList(String type) {

		LinkedHashMap<String, String> hashMap = new LinkedHashMap<>();
		hashMap.put( RecipyConfig.TB_STATUS+"='"+RecipyConfig.TB_NORMAL+"'","");
		hashMap.put( "meal_type = '"+type+"'"," and " );
		List<Meal> allList = this.getAllList( hashMap );
		return allList;
		
	}
}

