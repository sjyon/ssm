package com.jayon.ssm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jayon.ssm.pojo.UserDO;
import com.jayon.ssm.web.bind.annotation.CurrentUser;
@Controller
public class IndexController {
	@RequestMapping("/")
    public String index(UserDO loginUser, Model model) {
        model.addAttribute("user", loginUser);
        return "index";
    }
	@RequestMapping("/success")
	public String success(){
		return "success";
	}
	@RequestMapping("/unauthorized")
	public String unauthorized(){
		return "unauthorized";
	}
}
