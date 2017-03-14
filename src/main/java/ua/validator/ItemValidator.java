package ua.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.dto.form.ItemForm;

public class ItemValidator implements Validator {

	private final static Pattern PATTERNInt = Pattern.compile("^[0-9]+$");
	
	private final static Pattern PATTERN = Pattern.compile("^([0-9]{1,18}\\.[0-9]{0,2})|([0-9]{1,18}\\,[0-9]{0,2})|([0-9]{1,18})$");

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(ItemForm.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ItemForm item = (ItemForm) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "item", "", "Can`t be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "", "Can`t be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "capasity", "", "Can`t be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "eduranse", "", "Can`t be empty");
		if(!PATTERN.matcher(item.getPrice()).matches()){
			errors.rejectValue("price", "", "Wrong format, only 2 digits after separator");
		}
		if(!PATTERN.matcher(item.getCapasity()).matches()){
			errors.rejectValue("capasity", "", "Wrong format, only 2 digits after separator");
		
		}
		if(!PATTERNInt.matcher(item.getEduranse()).matches()){
			errors.rejectValue("eduranse", "" ,"Wrong format, only 2 digits after separator");
		
		}
	}
	}
