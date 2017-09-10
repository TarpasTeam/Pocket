package cn.tarpas.pocket.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tarpas.pocket.service.UserService;

@Controller
public class LoginAction {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginAction.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login.action")
	public void login(
			@RequestBody(required=false)String requestBody
		){
		
	}
	
	public static void main(String[] args) {
		
	}
}
