package com.vcc.recipe.recipe.service;
import com.vcc.recipe.common.IServiceOperations;
import com.vcc.recipe.recipe.domain.Visitor;
/** 
* 
* @author 吴彬 的  autoWeb 自动代码 网址  www.wubin9.com 
* @data 2019年08月26日 16:09:38  
* 此文件由 www.wubin9.com 网站的自动代码 autoWeb 自动生成。 
* 可以根据需求随意修改，如果需要帮助，请联系 吴彬 
* 联系方式：QQ 810978593  微信  wubin0830bingo 邮箱 wubin5922@dingtalk.com 
*/  

public interface IVisitorService extends IServiceOperations<Visitor> {
    
    
    public Visitor addVisitor(String device,String identifier) ;
    
    

}

