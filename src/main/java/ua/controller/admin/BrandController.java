package ua.controller.admin;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static ua.service.ParamBuilder.getParams;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.dto.form.BasicFilter;
import ua.editor.CountryEditor;
import ua.entity.Brand;
import ua.entity.Country;
import ua.service.BrandService;
import ua.service.CountryService;
import ua.validator.BrandValidator;

@Controller
@RequestMapping("/admin/brand")
@SessionAttributes(names="brand")
public class BrandController {
	  
		@Autowired
		private BrandService brandService;
		
		@Autowired
		private CountryService countryService;
		
		@InitBinder("brand")
		protected void initBinder(WebDataBinder binder){
		   binder.registerCustomEditor(Country.class, new CountryEditor(countryService));
		   binder.setValidator(new BrandValidator(brandService));
		}
		
		@ModelAttribute("brand")
		public Brand getForm(){
			return new Brand();
		}
		
		@ModelAttribute("filter")
		public BasicFilter getFilter(){
			return new BasicFilter();
		}
		
		@RequestMapping
		public String show(Model model,  @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
			model.addAttribute("page", brandService.findAll(filter, pageable));
			model.addAttribute("countries", countryService.findAll());
			return "admin-brand";
		}
		
		@RequestMapping("/update/{id}")
		public String update(@PathVariable int id, Model model,  @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
			model.addAttribute("brand", brandService.findOne(id));
			model.addAttribute("page", brandService.findAll(filter, pageable));
//			model.addAttribute("country", countryService.findAll());
			show(model, pageable, filter);
			return "admin-brand";
		}
		
		@RequestMapping("/delete/{id}")
		public String delete(@PathVariable int id,  @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
			brandService.delete(id);
			return "redirect:/admin/brand"+getParams(pageable, filter);
		}
		
		@RequestMapping(method=POST)
		public String save(@ModelAttribute("brand") @Valid Brand brand ,BindingResult br, SessionStatus status,Model model,  @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
			if(br.hasErrors()){
				model.addAttribute("countries", countryService.findAll());
				model.addAttribute("page", brandService.findAll(filter, pageable));
				return "admin-brand";
			}
			brandService.save(brand);
			status.setComplete();
			return "redirect:/admin/brand"+getParams(pageable, filter);
		}
}

