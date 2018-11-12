/**
 * 
 */
package com.service;

import java.util.HashMap;

/**
 * @author sunil
 *
 */
public interface LoginService {

	boolean authenticateUser(String userName, String password);

	String signUpUser(HashMap<String, String> requestData);
}
