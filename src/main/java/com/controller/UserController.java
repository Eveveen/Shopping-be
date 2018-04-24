package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.entity.User;
import com.service.iface.UserServiceIface;
import com.util.CreateApiKey;

@Controller
public class UserController {
	
	@Autowired
	public UserServiceIface userService;
	
	private User tempUser = new User();
	
	/**
	 * 根据用户名和密码判断是否登录成功
	 * @param user
	 * @param attrs
	 * @param request
	 * @return
	 */
	@RequestMapping("/login")
	@ResponseBody
	public String Login(User user, RedirectAttributes attrs,
			HttpServletRequest request) {

		String name = user.getUserName();
		String password = user.getPassword();
		System.out.println(name + ":::" + password);

		HttpSession session = request.getSession();

		User u = new User();
		u.setUserName(name);
		u.setPassword(password);

		User userResult = userService.findUserByNameAndPassword(u);
		int userId = 0;

		if (userResult != null) {
			
			System.out.println("loginName::: " + userResult.getUserName());
			userId = userResult.getUserId();
			session.setAttribute("userName", userResult.getUserName());
			return "true";
		} else {
			return "false";
		}
	}
	

	/**
	 * 点击获取验证码时，将获取到的手机号和对应的验证码保存在临时的对象中
	 * @param user
	 * @return
	 */
	@RequestMapping("/saveCode")
	@ResponseBody
	public String saveCode(User user){
		if(user.getValidateCode() == null){
			return "false";
		} else {
//			if(tempUser.getTelphone() != user.getTelphone() || tempUser.getValidateCode() == null){				
			tempUser.setValidateCode(user.getValidateCode());
			tempUser.setTelphone(user.getTelphone());
//			}
			return "true";
		}
	}
	
	/**
	 * 验证验证码，将接收到的参数与tempUser中的数据进行比对
	 * @param user
	 * @return
	 */
	@RequestMapping("/verifyCode")
	@ResponseBody
	public String verifyCode(User user){
		System.out.println("tem:" + tempUser.getValidateCode());
		if(userService.findUserByTelphone(user) != 0 || tempUser.getValidateCode() == null){
			return "false";
		} else if(tempUser.getValidateCode().equals(user.getValidateCode()) 
				&& tempUser.getTelphone().equals(user.getTelphone())&&userService.findUserByTelphone(user) == 0){
			return "true";
		} else {
			return "false";
		}
	}
	
	/**
	 * 注册新用户
	 * @param user
	 * @return
	 */
	@RequestMapping("/addUser")
	@ResponseBody
	public String addUser(User user){
		int result = userService.addUser(user);
		if(result == 0){			
			return "false";
		} else {			
			return "true";
		}
	}
	
	/**
	 * 根据用户姓名获取用户信息
	 * @param userName
	 * @return
	 */
	@RequestMapping("/getUserInfo")
	@ResponseBody
	public User getUserInfo(HttpServletRequest request, String userName){
//		System.out.println("hello");
//		HttpSession session = request.getSession();
//		String userName = (String) session.getAttribute("userName");
		User user = userService.findUserByName(userName);
		System.out.println(user.getTelphone());
		if(user == null){
			return null;
		} else {
			return user;
		}
	}
	
	/**
	 * 更新用户
	 * @param user
	 * @return
	 */
	@RequestMapping("/updateUser")
	@ResponseBody
	public int updateUser(User user){
		System.out.println("update,,," + user.getUserId());
		return userService.updateUserById(user);
	}
	
	/*public User findUserByName(String userName){
		User user = userService.findUserByName(userName);
		if(user != null ) {
			return user;
		} else {
			return null;
		}
	}*/
	
	@RequestMapping("/getSessionName")
	@ResponseBody
	public User getSessionName(HttpServletRequest request){
		System.out.println("hello");
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");
		if(userName == null){
			return null;
		} else {
			return userService.findUserByName(userName);
		}
	}
	
	@RequestMapping("/toRegister")
	public String toRegister(Model model,User user){
		CreateApiKey c = new CreateApiKey();
		String apikey = c.create();
		
		model.addAttribute("apikey",apikey);
//		user.setApiKey(apikey);
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
			System.out.println(userService.findUserByName(name).getUserName());
			
			return "1";
		}
	}
	
	@RequestMapping("/apikeyTologin/{apikey}")
	public String toLogin(@PathVariable(value="apikey") String apiKey,HttpServletRequest request,Model model){
		
		System.out.println(apiKey + "");
		User u = new User();
//		u.setApiKey(apiKey);
		
		int b = userService.updateActivationStatus(u);
		
		HttpSession session = request.getSession();
		session.removeAttribute("flag");
		
		model.addAttribute("flag", 1);
			
		return "redirect:/index";
	}

}
