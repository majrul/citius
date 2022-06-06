package com.citiustech.solid.srp.good;

class PasswordHasher {
	public String hashPassword(String password) {
		return null;
	}
}

class UserStore {
	public boolean userExists(String username, String password) {
		return false;
	}
}
class LoginService {
	
	private String loggedInUser = "";
	private PasswordHasher hasher = new PasswordHasher();
	private UserStore store = new UserStore();
	
	public void login(String username, String password) {
		String hash = hasher.hashPassword(password);
		if(store.userExists(username, hash))
			loggedInUser = username;
	}
	
	public void logout() {
		loggedInUser = "";
	}
	
	public String getLoggedInUsername() {
		return loggedInUser;
	}
}
public class Example2 {

}
