package com.vcc.recipe.interceptor;

import com.vcc.recipe.annotations.UnToken;

import com.vcc.recipe.annotations.VerityToken;
import com.vcc.recipe.util.RedisUtils;
import com.alibaba.fastjson.JSON;
import com.vcc.recipe.util.SecretUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;



@Component
public class VisitInterceptor implements HandlerInterceptor {

    private static final Log log = LogFactory.getLog("visitLog");


//    @Autowired
//    private CommonService commonService;
    @Autowired
    private RedisUtils redisUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (request == null) {
            log.info("VisitLogInterceptorAdapter|preHandle|request is null,false");
            return false;
        }
        UnToken annotation = null;
        VerityToken verityToken = null ;
        if(handler instanceof ResourceHttpRequestHandler) {
            log.info("ResourceHttpRequestHandler{}" + handler.toString());
        }else if(handler instanceof HandlerMethod){
            log.info("HandlerMethod{}" + handler.toString());
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            annotation = method.getAnnotation(UnToken.class);
            verityToken = method.getAnnotation( VerityToken.class );
        }
        if (annotation == null) {
            return true;
        }
        // 有UnToken注解,不拦截,没有注解必须有token
        String token = request.getHeader("access_token");
        StringBuffer buf = new StringBuffer();
        String parameter = request.getParameterMap() == null ? "" : JSON.toJSONString(request.getParameterMap());
        buf.append("|").append("IP=").append(this.getIpAddress(request));
        buf.append("|").append("X-Real-IP=").append(request.getHeader("X-Real-IP"));
        buf.append("|").append("RequestURI=").append(request.getRequestURI());
        buf.append("|").append("RequestURL=").append(request.getRequestURL());
        buf.append("|").append("referer=").append(request.getHeader("referer"));
        buf.append("|").append("RequestedSessionId=").append(request.getRequestedSessionId());
        buf.append("|").append("User-Agent=").append(request.getHeader("User-Agent"));
        buf.append("|").append("parameter=").append(parameter);
        buf.append("|").append("SessionId=").append(request.getSession().getId());
        buf.append("|").append("RemoteAddr=").append(request.getRemoteAddr());
        buf.append("|").append("RemoteHost=").append(request.getRemoteHost());
        buf.append("|").append("RemotePort=").append(request.getRemotePort());
        buf.append("|").append("token=").append(token);
        log.info(buf.toString());
        if (verityToken != null){   /// 验证token是否过期
            String value = this.redisUtils.getValue( token );
            if (value == null){
                try {
                    request.getRequestDispatcher("/error/verityToken").forward(request,response);
                } catch (ServletException|IOException e) {
                    e.printStackTrace();
                }
                return false ;
            }
        }
        if (token != null && token.length() != 0) {   /// 验证token是否正确
            String identifier = SecretUtil.getIdentifier( token );
            if (identifier != null) {
                String[] strings = new String[1];
                strings[0] = "identifer";
                request.setAttribute( "identifier", identifier );
                return true;
            }
        }
        try {
            request.getRequestDispatcher("/error/tokenError").forward(request,response);
        } catch (ServletException|IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip.contains(",")) {
            return ip.split(",")[0];
        } else {
            return ip;
        }
    }

}

