package com.fshouse.controllers;


import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fshouse.DAOs.UserDAO;
import com.fshouse.models.User;

@Controller
public class UserController {
	
	
	@RequestMapping(value = "submitLogin", method = POST)
	public String loginSubmitHandler(Model model, User user,HttpServletRequest request) {
		model.addAttribute("user", user);
		
		String username = user.getUsername();
		String password = user.getPassword();
		
		UserDAO userdao = new UserDAO();
		User loggedUser = userdao.getFromTable(username);

		if (!(loggedUser == null))
		{
			String correctPassword = loggedUser.getPassword();
			if(password.equals(correctPassword))
			{
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				String status = "Successfully Logged In";
				session.setAttribute("status", status);
				return "userProfile";
			}
			else
			{
				request.setAttribute("message", "Wrong Password");
				return "login";
			}
		}
		else
		{
			request.setAttribute("message", "Wrong Username");
			return "login";
		}
	}
	
	
	
	
	
	@RequestMapping(value = "submitRegister", method = POST)
	public String registerSubmitHandler(Model model, User user,HttpServletRequest request) {
		model.addAttribute("user", user);
		
		String username = user.getUsername();
		String password = user.getPassword();
		String email = user.getEmail();
		
		if(username.equals(""))
		{
			request.setAttribute("message", "Username Cannot Be Empty");
			return "signupform";
		}
		if(password.equals(""))
		{
			request.setAttribute("message", "Password Cannot Be Empty");
			return "signupform";
		}
		if(username.contains(" "))
		{
			request.setAttribute("message", "Username Cannot Contain Space");
			return "signupform";
		}
		UserDAO userdao = new UserDAO();
		User loggedUser = userdao.getFromTable(username);
		
		if (loggedUser==null)
		{
			userdao.insertIntoTable(new User(username,password,email));
			return "login";
		}
		else
		{
			request.setAttribute("message", "username already exists");
			return "signupform";
		}
	}
	
	@RequestMapping(value = "logout")
	public String usersLogout(Model model,HttpSession session) {
		model.addAttribute("user", new User());
		return "login";
	}
	

	
	@RequestMapping(value = "usersprofile")
	public String usersHomePageHandler(Model model,HttpServletRequest request,HttpSession session) {
		String status = "Welcome To Homepage";
		session.setAttribute("status", status);
		return "usersprofile";
	}
	
	
	
}
