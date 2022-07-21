package webapp.service;

public class LoginService {
	public boolean validateUser(String user, String password) {
		return user.equalsIgnoreCase("praveen") && password.equals("pass");
	}

}