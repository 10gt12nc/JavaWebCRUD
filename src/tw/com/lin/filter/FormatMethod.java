package tw.com.lin.filter;

import java.util.regex.Pattern;

public class FormatMethod {

	private final Pattern usernameRegex = Pattern.compile("^[\\w\\u4e00-\\u9fa5]{1,16}$");
	private final Pattern passwordRegex = Pattern.compile("^\\w{6,16}$");
	private final Pattern emailRegex = Pattern
			.compile("^\\w{1,63}@[a-zA-Z0-9]{2,63}\\.[a-zA-Z]{2,63}(\\.[a-zA-Z]{2,63})?$");

	public boolean validateUsername(String username) {
		return usernameRegex.matcher(username).find();
	}

	public boolean validatePassword(String password, String password2) {
		return passwordRegex.matcher(password).find() && password.equals(password2);
	}

	public boolean validateEmail(String email) {
		return emailRegex.matcher(email).find();
	}

}
