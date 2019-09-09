package com.vcc.recipe.recipe.controller.error;

import com.vcc.recipe.annotations.UnToken;
import com.vcc.recipe.common.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping(value = "/error")
@RestController
public class ErrorController {
    
    @Autowired
    private JsonResult jsonResult ;
    
    @UnToken 
    @RequestMapping(value = "/tokenError")
    public String tokenError(HttpServletRequest request, HttpServletResponse response){
        return jsonResult.error( -200,"token 为空或不正确" );
    }
    
    @UnToken
    @RequestMapping(value = "/verityToken" )
    public String verityToken(HttpServletRequest request , HttpServletResponse response){
        return jsonResult.error( -30,"token 已过期,请重新登录" );
    }
    
}
