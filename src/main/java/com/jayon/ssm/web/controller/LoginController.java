package com.jayon.ssm.web.controller;

import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jayon.ssm.realm.UserRealm;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;


@Controller
public class LoginController {
	private final static Logger logger = LoggerFactory.getLogger(LoginController.class);
	@Autowired
	UserRealm userRealm;
	
	@RequestMapping(value = "/login")
    public String showLoginForm(HttpServletRequest req, Model model) {
        String exceptionClassName = (String)req.getAttribute("shiroLoginFailure");
        String error = null;
        if(UnknownAccountException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
        } else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
        } else if(ExcessiveAttemptsException.class.getName().equals(exceptionClassName)) {
            error = "输入错误密码超过5次";
        }  else if(exceptionClassName != null) {
            error = "其他错误：" + exceptionClassName;
        }
        Cache c = userRealm.getAuthorizationCache();
        Set<Object> keys = c.keys();
        for(Object o:keys) {
            logger.info("授权缓存:{}-----{}----------",o,c.get(o));
        }
        
        c = userRealm.getAuthenticationCache();
        keys = c.keys();
        for(Object o:keys) {
        	 logger.info("授权缓存:{}-----{}----------",o,c.get(o));
        }
        model.addAttribute("error", error);
        return "login";
    }


}
