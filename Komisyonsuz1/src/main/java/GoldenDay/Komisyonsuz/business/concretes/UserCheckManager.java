package GoldenDay.Komisyonsuz.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import GoldenDay.Komisyonsuz.business.abstracts.UserCheckService;
@Service
public class UserCheckManager implements UserCheckService {

	@Override
	public boolean isValidEMail(String email) {


		String expression = "^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
		CharSequence inputStr = email;

		Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(inputStr);
		return matcher.matches();
	}

	

	@Override
	public boolean isFirstNameOk(String firstName) {
		Pattern validNamePattern = Pattern.compile("[A-Z][a-z]*");
		Matcher validNameMatcher = validNamePattern.matcher(firstName);
		return validNameMatcher.matches();
	}

	@Override
	public boolean isLastNameOk(String lastName) {
		Pattern validLastNamePattern = Pattern.compile("[A-Z]+([ '-][a-zA-Z]+)*");
		Matcher validLastNameMatcher = validLastNamePattern.matcher(lastName);
		return validLastNameMatcher.matches();
	}

	@Override
	public boolean isPasswordOk(String password) {
		Pattern validPasswordPattern = Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\\\S+$).{8,}");
		Matcher validPasswordMatcher = validPasswordPattern.matcher(password);
		return validPasswordMatcher.matches();
	}
	



}
