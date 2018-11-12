package com.controller;
 
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.response.Response;
import com.response.SuccessResponse;
import com.service.LoginService;

 
@Controller
@RequestMapping("users")
public class UserController {
 
	@Autowired
	@Qualifier("loginService")
	LoginService loginService;

 
	@RequestMapping(value = "authenticate", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public @ResponseBody Response  authenticateUser(@RequestBody HashMap<String, String> requestData, HttpServletRequest request) throws Exception {
		
		String userName = requestData.get("userName");
		String password = requestData.get("password");
		this.loginService.authenticateUser(userName, password);
		return new SuccessResponse(JsonNodeFactory.instance.objectNode().put("Name", userName).put("password", password));
		
	}
	
	@RequestMapping(value = "signup", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public @ResponseBody Response  getPatientCallScheduleData(@RequestBody HashMap<String, String> requestData, HttpServletRequest request) throws Exception {
		
		return new SuccessResponse(this.loginService.signUpUser(requestData));
		
	}
	 
}