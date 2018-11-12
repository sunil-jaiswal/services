package com.serviceImpl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.DateUtils;
import com.dao.LoginDao;
import com.domain.TypesData;
import com.domain.User;
import com.service.LoginService;


@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao loginDao;
	
	public boolean authenticateUser(String userName, String password) {
		
		return this.loginDao.authenticateUser(userName, password);
	}
	
	public String signUpUser(HashMap<String, String> requestData) {
		
		User user = new User();
		Long roleId = Long.valueOf(requestData.get("roleId"));
		
		user.setCreatedDate(DateUtils.nowTimestamp);
		user.setFirstName(requestData.get("firstName"));
		user.setLastName(requestData.get("lastName"));
		user.setPassword(requestData.get("password"));
		user.setRoleId(new TypesData(roleId));
		user.setEmail(requestData.get("email"));
		
		this.loginDao.save(user);
		return null;
	}

}
