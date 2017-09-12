package cn.tarpas.pocket.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.async.DeferredResult;

import cn.tarpas.pocket.common.dto.ErrorStatus;
import cn.tarpas.pocket.common.dto.WebMessage;
import cn.tarpas.pocket.dto.LoginReq;
import cn.tarpas.pocket.dto.LoginRsp;
import cn.tarpas.pocket.po.User;
import cn.tarpas.pocket.service.UserService;
import cn.tarpas.pocket.util.JsonMapper;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginAction {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginAction.class);
	private static final JsonMapper JSON_MAPPER = new JsonMapper();
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login.action",method = RequestMethod.POST)
	public DeferredResult<LoginRsp> login(
			@RequestBody(required=false)String requestBody,
			HttpServletRequest httpRequest,
			HttpServletResponse httpResponse
		){
		LoginReq loginReq = JSON_MAPPER.fromJson(requestBody,LoginReq.class);
		
		DeferredResult<LoginRsp> loginRsp =new DeferredResult<LoginRsp>();
		
		User user = new User();
		user.setPhone(loginReq.getTelphone());
		user.setPassword(loginReq.getPassword());
		
		boolean exist = userService.userExist(user);
		if(!exist){
			loginRsp.setErrorResult(ErrorStatus.ERR_MEMBER_NOT_EXIST);
			return loginRsp;
		}
		
		boolean result = userService.login(user);
		if(!result){
			loginRsp.setErrorResult(ErrorStatus.ERR_PASSWORD);
			return loginRsp;
		}
		
		loginRsp.setErrorResult(ErrorStatus.SUCCESS);
		
		return loginRsp;
		
	}
	
	public static void main(String[] args) {
		String requestBody = "{'telphone':'13952181347','password':'Y1c9L5HyY'}";
		LoginReq loginReq = JSON_MAPPER.fromJson(requestBody,LoginReq.class);
		System.out.println(loginReq.toString());
	}
}
