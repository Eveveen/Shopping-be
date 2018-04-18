package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.User;
import com.service.iface.UserServiceIface;
import com.util.CreateApiKey;

@Controller
public class RegisterController {
	
	@Autowired
	public UserServiceIface userService;
	
	@RequestMapping("/toRegister")
	public String toRegister(Model model,User user){
		CreateApiKey c = new CreateApiKey();
		String apikey = c.create();
		
		model.addAttribute("apikey",apikey);
		user.setApiKey(apikey);
		int b = userService.addUser(user);
		if(b != 0){
			
			return "apikey";
		}else{
			
			return null;
		}
	}
	
	@RequestMapping(value="ajax",produces="text/html;charset=utf-8")
	@ResponseBody
	public Object ajax(HttpServletRequest request){
		
		String name = request.getParameter("username");
		System.out.println(name);
		//User u = new User();
		//u.setName(name);
		if(userService.findUserByName(name) == null){ //注册时验证用户是否存在
			
			return "0";   // 不存在
		} else{
			System.out.println(userService.findUserByName(name).getName());
			
			return "1";
		}
	}
	
	@RequestMapping("/apikeyTologin/{apikey}")
	public String toLogin(@PathVariable(value="apikey") String apiKey,HttpServletRequest request,Model model){
		
		System.out.println(apiKey + "");
		User u = new User();
		u.setApiKey(apiKey);
		
		int b = userService.updateActivationStatus(u);
		
		HttpSession session = request.getSession();
		session.removeAttribute("flag");
		
		model.addAttribute("flag", 1);
			
		return "redirect:/index";
	}

}
