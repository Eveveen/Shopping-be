package com.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.entity.User;
import com.entity.UserMessage;
import com.service.iface.UserMessageServiceIface;
import com.service.iface.UserServiceIface;

@Controller
public class LoginController {

	@Autowired
	public UserServiceIface userService;

	@Autowired
	public UserMessageServiceIface userMessageService;

	@RequestMapping("/toLogin")
	public void Login1(Model model, User user, RedirectAttributes attrs,
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

		model.addAttribute("message", "");
		if (userResult != null) {
			
			System.out.println("loginName::: " + userResult.getUserName());
			userId = userResult.getUserId();
			List<UserMessage> msgList = userMessageService
					.findMsgByReceiverId(userId);

			// 统计未读消息
			int count = 0;
			for (UserMessage um : msgList) {
				System.out.println(um.getMsg() + ":::" + um.getReadStatus());
				if (um.getReadStatus() == 0) {
					count++;
				}
			}

			session.setAttribute("count", count);

//			System.out.println("API KEY:::" + userResult.getApiKey());
//			System.out.println("ActiveStatus:::"
//					+ userResult.getActivationStatus());
//			session.setAttribute("user", userResult);
//			if (userResult.getActivationStatus() == 1) {
//				attrs.addAttribute("userId", userId);
//				session.removeAttribute("activationStatus");
//				session.setAttribute("apiKey", userResult.getApiKey());
//				return "redirect:/toIndex";
//			} else {
//				model.addAttribute("flag", "0");
//				session.setAttribute("activationStatus", userResult.getActivationStatus());
//				session.setAttribute("apiKey", userResult.getApiKey());
//				return "index";
//			}
		} else {
			model.addAttribute("message", "用户名或密码错误，请重新登录！");
//			return "login";
		}
	}

	@RequestMapping("/indexToUserProfile")
	public String toUserProfile(HttpServletRequest request,
			RedirectAttributes attrs) {

		return "redirect:/user_profile";
	}

	@RequestMapping("/{toPage}/editUser")
	public String save(@PathVariable(value = "toPage") String toPage,
			User user, HttpServletRequest request, Model model) {
		System.out.println(user.getUserName());

		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");

		if (user.getPassword() != null) {
			u.setPassword(user.getPassword());
		} else {
			u.setEmail(user.getEmail());
//			u.setDescription(user.getDescription());
		}

		userService.updateUser(u);
		session.setAttribute("user", u);

		return "redirect:/{toPage}";
	}

	@RequestMapping("/indexTonotifications/{userId}")
	public String toNotifications(Model model,
			@PathVariable(value = "userId") int receiverId,
			HttpServletRequest request) {
		System.out.println(receiverId);
		List<UserMessage> msgList = userMessageService
				.findMsgByReceiverId(receiverId);
		for (UserMessage um : msgList) {
			System.out.println("sendId:::" + um.getSenderId());
			String senderName = userService.findSenderBySenderId(
					um.getSenderId()).getUserName();

			Date d = new Date();
			int min = (int) ((d.getTime() - um.getSendTime().getTime()) / 60000);
			if (min <= 1) {
				um.setIntervalTime("刚刚");
			} else if (min <= 60) {

				um.setIntervalTime(min + "分钟前");
			} else if (min <= 1440) {

				int hour = min / 60;
				um.setIntervalTime(hour + "小时前");
			} else {

				int day = min / 1440;
				um.setIntervalTime(day + "天前");
			}
			um.setSenderName(senderName);
		}

		userMessageService.updateReadStatus(receiverId);
		HttpSession session = request.getSession();
		session.setAttribute("count", "0");
		// model.addAttribute("count", "0");
		model.addAttribute("msgs", msgList);

		return "notifications";
		// return null;
	}

}
