package ua.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.entity.GiftBox;
import ua.service.GiftBoxService;

public class GiftBoxValidator implements Validator {

	private final GiftBoxService giftBoxService;	
	
	public GiftBoxValidator(GiftBoxService giftBoxService) {
		this.giftBoxService = giftBoxService;
	}

	
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(GiftBox.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		GiftBox giftBox  = (GiftBox) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "giftBox", "", "Can`t be empty");
		if(giftBoxService.findByGiftBox(giftBox.getGiftBox())!=null){
			errors.rejectValue("giftBox", "", "Already exist");
		}
	} 
}
	
