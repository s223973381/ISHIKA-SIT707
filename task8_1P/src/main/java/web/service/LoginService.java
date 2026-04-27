package web.service;


public class LoginService {


	public static boolean login(String username, String password, String dob) {
		// Match a fixed user name and password.
		//
		if ("ishika".equals(username) && "ishika_pass".equals(password)) {
			return true;
		}
		return false;
	}
	
	
}
