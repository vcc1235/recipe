package com.vcc.recipe.recipe.controller.base;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSON;
import java.math.BigDecimal;

import com.vcc.recipe.common.JsonResult;
import com.vcc.recipe.recipe.service.IMealService;
import com.vcc.recipe.recipe.domain.Meal;
import com.vcc.recipe.recipe.vo.MealVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
/** 
* 
* @author 吴彬 的  autoWeb 自动代码 网址  www.wubin9.com 
* @data 2019年08月23日 22:53:10  
* 此文件由 www.wubin9.com 网站的自动代码 autoWeb 自动生成。 
* 可以根据需求随意修改，如果需要帮助，请联系 吴彬 
* 联系方式：QQ 810978593  微信  wubin0830bingo 邮箱 wubin5922@dingtalk.com 
*/  


@Api(tags="MealController")
@RestController
@RequestMapping("/recipe/base/meal")
public class MealController {

private static Logger logger = LoggerFactory.getLogger("programLog");

	@Autowired
	protected JsonResult jsonResult;


	@Resource
	protected IMealService mealService;



	@RequestMapping(value = "/getMealList" , method = RequestMethod.POST)
	public String getMealList(@RequestParam(value = "pageNo",defaultValue = "1") Integer pageNo, @RequestParam(value = "pageSize",defaultValue = "20") Integer pageSize){
		if (pageNo < 1){
			pageNo = 1 ;
		}
		List<Meal> mealList = mealService.getMealList( pageNo, pageSize );
		Integer mealCount = mealService.getMealCount();
		HashMap<String, Object> hashMap = new HashMap<>();
		hashMap.put( "list",mealList );
		hashMap.put( "total",String.valueOf( mealCount ) );
		return this.jsonResult.ok( hashMap );
	}

	@RequestMapping(value = "/aeMeal" , method = RequestMethod.POST)
	public String aeMeal(String name,String type){
		int i = mealService.addMeal( name,type );
		if (i==1){
			return jsonResult.ok( "成功" );
		}else {
			return jsonResult.error( -1,"失败" );
		}
	}
	
	@RequestMapping(value = "/searchMeal",method = RequestMethod.POST)
	public String editMeal(@RequestParam(value = "keyword") String keyword){
		
		List<Meal> mealList = this.mealService.searchMealList( keyword);
		return this.jsonResult.ok( mealList );
		
	}
	
	@RequestMapping(value = "/getOneMealById",method = RequestMethod.POST)
	public String getOneById(@RequestParam(value = "mealId") Integer mealId){
		Meal meal = this.mealService.getOneMeal( mealId );
		return this.jsonResult.ok(meal) ;
	}
	
	@RequestMapping(value = "/editMeal",method = RequestMethod.POST)
	public String editMeall(@RequestParam(value = "mealId") Integer mealId,@RequestParam(value = "name") String name,@RequestParam(value = "type") String type){
		int i = this.mealService.updateMeal( mealId, name, type );
		if (i>0){
			return this.jsonResult.ok();
		}
		return this.jsonResult.error( -1 ,"失败");
	}
	
	@RequestMapping(value = "/deleteMeal",method = RequestMethod.POST)
	public String deleteMeal(@RequestParam(value = "mealId") Integer mealId){
		int i = this.mealService.deleteMeal( mealId );
		if (i>0){
			return this.jsonResult.ok();
		}
		return this.jsonResult.error( -1,"删除失败" );
	}
	
}

