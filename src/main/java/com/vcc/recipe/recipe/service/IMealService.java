package com.vcc.recipe.recipe.service;
import com.vcc.recipe.common.IServiceOperations;
import com.vcc.recipe.recipe.domain.Meal;

import java.util.List;

/** 
* 
* @author 吴彬 的  autoWeb 自动代码 网址  www.wubin9.com 
* @data 2019年08月23日 22:53:10  
* 此文件由 www.wubin9.com 网站的自动代码 autoWeb 自动生成。 
* 可以根据需求随意修改，如果需要帮助，请联系 吴彬 
* 联系方式：QQ 810978593  微信  wubin0830bingo 邮箱 wubin5922@dingtalk.com 
*/  

public interface IMealService extends IServiceOperations<Meal> {

    //// 后台
    public List<Meal> getMealList(Integer page , Integer pageSize);
    
    public Integer getMealCount();
    
    public int addMeal(String name ,String type);
    
    public Meal getOneMeal(int mealId);
    
    public int updateMeal(int mealId , String name , String type) ;
    
    public int deleteMeal (int mealId);
    
    public List<Meal> searchMealList(String keyword) ;
    
    
    /// Api
    
    public List<Meal> getMealList(String type);
    
    
}

