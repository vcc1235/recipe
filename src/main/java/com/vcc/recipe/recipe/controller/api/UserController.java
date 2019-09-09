package com.vcc.recipe.recipe.controller.api;

import com.vcc.recipe.annotations.UnToken;
import com.vcc.recipe.common.JsonResult;
import com.vcc.recipe.recipe.domain.Visitor;
import com.vcc.recipe.recipe.service.impl.VisitorService;
import com.vcc.recipe.recipe.vo.VisitorVo;
import com.vcc.recipe.util.RSAUtil;
import com.vcc.recipe.util.RedisUtils;
import com.vcc.recipe.util.SecretUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Api(tags = "UserController")
@RestController
@RequestMapping(value = "/user")
public class UserController {
    
    @Autowired
    private JsonResult jsonResult;
    
    @Autowired
    private VisitorService visitorService ;
    
    @Autowired
    private RedisUtils redisUtils ;
    
    
    /** 游客进入 **/
    @UnToken
    @ApiOperation(value = "获取游客信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "device",value = "系统类型",paramType = "query",dataType = "String",required = true),
            @ApiImplicitParam(name = "identifier",value = "设备信息",paramType = "query",dataType = "String",required = true),
            @ApiImplicitParam(name = "sign",value = "参数签名",paramType = "query",dataType = "String",required = true)
    })
    @RequestMapping(value = "/doVisitor",method = RequestMethod.POST)
    public String doVisitor(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "device" ) String device,@RequestParam(value = "identifier") String identifier,@RequestParam(value = "sign") String sign){
        
        String string = identifier + device;
        String base64Encode = SecretUtil.base64Encode( string );
        String md5 = SecretUtil.md5( base64Encode );
        if (md5.equals( sign ) == false){   /// 验证签名信息
            return this.jsonResult.error( -2,"sign is error" );
        }
        
        Visitor visitor = visitorService.addVisitor( device, identifier );
        String token = SecretUtil.getIdentifier(visitor.getVisitorId());
        try {
            Map<String, Object> genKeyPair = RSAUtil.genKeyPair();
            String privateKey = RSAUtil.getPrivateKey( genKeyPair );
            String publicKey = RSAUtil.getPublicKey( genKeyPair );
            this.redisUtils.addToRedis( token,privateKey,7,TimeUnit.DAYS);
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put( "token",token);
            hashMap.put( "public",publicKey);
            hashMap.put( "visitor",new VisitorVo( visitor ) );
           return this.jsonResult.ok( hashMap );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.jsonResult.error( -1,"获取信息失败" );
    }
    
    
    
}
