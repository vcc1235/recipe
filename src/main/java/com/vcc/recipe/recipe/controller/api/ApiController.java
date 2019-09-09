package com.vcc.recipe.recipe.controller.api;


import com.vcc.recipe.common.JsonResult;
import com.vcc.recipe.recipe.domain.Meal;
import com.vcc.recipe.recipe.service.impl.MealService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Api(tags = "ApiController")
@RestController 
@RequestMapping(value = "/api")
public class ApiController {
    
    @Resource
    JsonResult jsonResult ;
    
    @Resource
    MealService mealService ;
    
    @ApiOperation( value = "获取菜单列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access_token", value = "token验证", paramType = "header", required = true),
            @ApiImplicitParam(name = "type", value = "日餐/菜式", required = true, defaultValue = "日餐", paramType = "query", dataType = "String")
    })
    @RequestMapping(value = "/menuList",method = RequestMethod.POST)
    public String menuList(HttpServletRequest request , HttpServletResponse response, @RequestParam(value = "type",defaultValue = "日餐") String type){

        List<Meal> mealList = this.mealService.getMealList( type );

        return jsonResult.ok( mealList );
        
    }    
    
    
    
    
    
}
