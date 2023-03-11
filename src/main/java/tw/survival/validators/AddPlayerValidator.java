package tw.survival.validators;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import tw.survival.model.Player.PlayerBean;

@Component
public class AddPlayerValidator implements Validator {

	private static final Pattern PHONE_REGEX = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$");
	private static final Pattern EMAIL_REGEX = Pattern.compile("^[\\w\\d._-]+@[\\w\\d.-]+\\.[\\w\\d]{2,6}$");

	@Override
	public boolean supports(Class<?> clazz) {
		boolean b = PlayerBean.class.isAssignableFrom(clazz);
		return b;
	}

	@Override
	public void validate(Object target, Errors errors) {
		PlayerBean player = (PlayerBean) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account", "player.account.not.empty", "帳號欄不能空白");
		ValidationUtils.rejectIfEmpty(errors, "password", "player.password.not.empty", "密碼欄不能空白");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "player.name.not.empty", "姓名欄不能空白");
		ValidationUtils.rejectIfEmpty(errors, "county", "player.county.not.empty", "縣市欄不能空白");
		ValidationUtils.rejectIfEmpty(errors, "district", "player.district.not.empty", "地區欄不能空白");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "player.password.not.empty", "地址欄不能空白");
		ValidationUtils.rejectIfEmpty(errors, "email", "", "信箱欄不能空白");
		ValidationUtils.rejectIfEmpty(errors, "age", "player.age.not.empty", "年齡欄不能空白");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "identity_number", "player.identity_number.not.empty",
				"個人身分欄不能空白");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "player.phone.not.empty", "電話欄不能空白");
		ValidationUtils.rejectIfEmpty(errors, "birthday", "player.birthday.not.empty", "生日欄不能空白");
		if (player.getName() != null && player.getName().length() > 0 && player.getName().length() < 2
				|| player.getName().length() > 30) {
			errors.rejectValue("name", "player.name.size", "姓名欄至少要有兩個字元，最多不得超過30個字元");
		}

		if (player.getPassword() != null && player.getPassword().contains(" ")) {
			errors.rejectValue("password", "player.password.space", "密碼欄不能包含空白字元");
		}
		if (player.getPassword() != null && player.getPassword().length() > 0
				&& (player.getPassword().length() < 5 || player.getPassword().length() > 30)) {
			errors.rejectValue("password", "player.password.size", "密碼欄至少要有五個字元，最多不得超過30個字元");
		}
		if (player.getEmail() != null && player.getEmail().length() > 0
				&& !EMAIL_REGEX.matcher(player.getEmail()).matches()) {
			errors.rejectValue("email", "player.email.invalid", "電子郵件地址的格式不正確");
		}
		if (player.getPhone() != null && player.getPhone().length() > 0
				&& PHONE_REGEX.matcher(player.getPhone()).matches()) {
			errors.rejectValue("phone", "player.phone.invalid", "電話的格式不正確");
		}

	}
}
