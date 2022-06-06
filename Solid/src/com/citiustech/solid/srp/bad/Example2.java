package com.citiustech.solid.srp.bad;

/*
 * The various responsibilities of this code:
 * 1. login/logout
 * 2. password hashing
 * 3. user store
 */
class LoginService {
	
	private String loggedInUser = "";
	
	public void login(String username, String password) {
		String hash = hashPassword(password);
		if(userExistsInDb(username, hash))
			loggedInUser = username;
	}
	
	public void logout() {
		loggedInUser = "";
	}
	
	public String getLoggedInUsername() {
		return loggedInUser;
	}
	
	private String hashPassword(String password) {
		return null;
	}

	private boolean userExistsInDb(String username, String hash) {
		return false;
	}
}
public class Example2 {

}
