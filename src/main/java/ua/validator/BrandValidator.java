package ua.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.entity.Brand;
import ua.service.BrandService;

public class BrandValidator implements Validator {

private final BrandService brandService;	
	
	public BrandValidator(BrandService brandService) {
		this.brandService = brandService;
	}

	
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(Brand.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Brand brand  = (Brand) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "brand", "", "Can`t be empty");
		if(brandService.findByBrand(brand.getBrand())!=null){
			errors.rejectValue("brand", "", "Already exist");
		}
	}

}
