package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.entity.Img;
import com.entity.User;
import com.service.iface.ImgServiceIface;
import com.service.iface.UserServiceIface;
import com.util.CreateApiKey;

@Controller
public class UserController {
	
	@Autowired
	public UserServiceIface userService;
	
	@Autowired
	public ImgServiceIface imgService;
	
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
	public User Login(User user, RedirectAttributes attrs,
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
			return userResult;
		} else {
			return null;
		}
	}
	

	/**
	 * 点击获取验证码时，将获取到的手机号和对应的验证码保存在临时的对象中
	 * @param user
	 * @return
	 */
	@RequestMapping("/saveCode/{sendCode}/{telphone}")
	@ResponseBody
	public boolean saveCode(@PathVariable(value="sendCode") String sendCode, @PathVariable(value="telphone") String telphone){
		System.out.println("saveCode==" + sendCode + "::::" + telphone);
		if(sendCode == null || telphone == null){
			return false;
		} else {
//			if(tempUser.getTelphone() != user.getTelphone() || tempUser.getValidateCode() == null){				
			tempUser.setValidateCode(sendCode);
			tempUser.setTelphone(telphone);
//			}
			return true;
		}
	}
	
	/**
	 * 验证验证码，将接收到的参数与tempUser中的数据进行比对
	 * @param user
	 * @return
	 */
	@RequestMapping("/verifyCode")
	@ResponseBody
	public String verifyCode(@RequestBody User user){
		System.out.println("tem:" + tempUser.getValidateCode() + "::: user=" + user.getValidateCode() 
				+ ":::tel:::" + user.getTelphone() + "::TEM::" + tempUser.getTelphone());
		if(userService.findUserByTelphone(user) != 0 || tempUser.getValidateCode() == null){
			System.out.println("AAA");
			return "tel";
		} else if(userService.findUserByName(user.getUserName()) != null){
			return "user";
		} else if(tempUser.getValidateCode().equals(user.getValidateCode()) 
				&& tempUser.getTelphone().equals(user.getTelphone())&&userService.findUserByTelphone(user) == 0){
			return "true";
		} else {
			System.out.println("BBB");
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
		User user = userService.findUserByName(userName);
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
	public boolean updateUser(User user){
		if(userService.updateUserById(user) == 1) {
			return true;
		} else {			
			return false;
		}
	}
	
	/**
	 * 管理员更新用户
	 * @param user
	 * @return
	 */
	@RequestMapping("/editUser")
	@ResponseBody
	public boolean editUser(User user){
		if(userService.editUserById(user) == 1) {
			return true;
		} else {			
			return false;
		}
	}
	
	/**
	 * 上传图片
	 * @param img
	 * @return
	 */
	@RequestMapping("/uploadImg")
	@ResponseBody
	public int uploadImg(@RequestBody Img img){
		return imgService.createImg(img);
	}
	
	/**
	 * 根据图片id获取图片
	 * @param imgId
	 * @return
	 */
	@RequestMapping("/getImg")
	@ResponseBody
	public Img getImgById(Integer imgId){
		return imgService.getImgById(imgId);
	}
	
	/**
	 * 获取所有用户
	 * @return
	 */
	@RequestMapping("/getAllUser")
	@ResponseBody
	public List<User> getAllUser(){
		return userService.findAllUser();
	}
	
	/**
	 * 删除用户
	 * @return
	 */
	@RequestMapping("/deleteUser")
	@ResponseBody
	public boolean deletelUser(Integer userId){
		if(userService.deleteUser(userId) == 1){
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 根据买家编号获取买家信息
	 * @param userId
	 * @return
	 */
	@RequestMapping("/getUser")
	@ResponseBody
	public User findUserByUserId(Integer userId){
		return userService.findUserByUserId(userId);
	}
	
	
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

}
