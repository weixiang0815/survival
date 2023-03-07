package tw.survival.validators;

import java.util.Set;

import javax.validation.ConstraintViolation;

import javax.validation.executable.ExecutableValidator;
import javax.validation.metadata.BeanDescriptor;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import tw.survival.model.Player.PlayerBean;

@Component
public class Playervalidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		boolean b = PlayerBean.class.isAssignableFrom(clazz);
		return b;
	}

	@Override
	public void validate(Object target, Errors errors) {
		PlayerBean player = (PlayerBean) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account", "player.account.not.empty", "帳號欄不能空白");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "player.password.not.empty", "密碼欄不能空白");

		if (!errors.hasFieldErrors("account") && player.getAccount().length() < 5) {
			errors.rejectValue("account", "player.account.length.error", "帳號欄不能小於五個字元(預設值)");
		}

	}

}
