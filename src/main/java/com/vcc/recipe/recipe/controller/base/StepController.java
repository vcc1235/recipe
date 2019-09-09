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
import com.vcc.recipe.recipe.service.IStepService;
import com.vcc.recipe.recipe.domain.Step;
import com.vcc.recipe.recipe.vo.StepVo;
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


@Api(tags="StepController")
@RestController
@RequestMapping("/recipe/base/step")
public class StepController {

private static Logger logger = LoggerFactory.getLogger("programLog");

	@Autowired
	protected JsonResult jsonResult;


	@Resource
	protected IStepService stepService;

	

}

