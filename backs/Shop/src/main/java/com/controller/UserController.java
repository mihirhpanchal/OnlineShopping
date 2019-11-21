package com.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.Users;
import com.service.UserService;


@Controller("mycontroller")
public class UserController {
	
	@Autowired
	 public UserService userService;
	
	@RequestMapping(value = "/userdetails", method = RequestMethod.GET)
	public ModelAndView viewusers(HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	
		String userid ="101";
		Users users =userService.getUser(userid);
		 ModelAndView mav = new ModelAndView("userhome");
		 mav.addObject("user", users);
		 return mav;
	 }
	

}