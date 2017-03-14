package ua.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.entity.Kind;
import ua.service.KindService;

public class KindValidator implements Validator {

	private final KindService kindService;	
	
	public KindValidator(KindService kindService) {
		this.kindService = kindService;
	}

	
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(Kind.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Kind kind  = (Kind) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "kind", "", "Can`t be empty");
		if(kindService.findByKind(kind.getKind())!=null){
			errors.rejectValue("kind", "", "Already exist");
		}
	} 
}

