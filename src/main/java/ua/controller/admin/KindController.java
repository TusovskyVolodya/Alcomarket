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
import ua.editor.CategoryEditor;
import ua.entity.Category;
import ua.entity.Kind;
import ua.service.CategoryService;
import ua.service.KindService;
import ua.validator.KindValidator;

@Controller
@RequestMapping("/admin/kind")
@SessionAttributes(names="kind")
public class KindController {
	
	@Autowired
	private KindService kindService;
	
	@Autowired
	private CategoryService categoryService;
	
	@ModelAttribute("kind")
	public Kind getForm(){
		return new Kind();
	}
	
	@InitBinder("kind")
	protected void initBinder(WebDataBinder binder) {
		 binder.registerCustomEditor(Category.class, new CategoryEditor(categoryService));
		binder.setValidator(new KindValidator(kindService));
	}
	
	@ModelAttribute("filter")
	public BasicFilter getFilter(){
		return new BasicFilter();
	}
	
	@RequestMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		model.addAttribute("page", kindService.findAll(filter, pageable));
		model.addAttribute("categories", categoryService.findAll());
		return "admin-kind";
	}
	
	
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		kindService.delete(id);
		return "redirect:/admin/kind"+getParams(pageable, filter);
	}
	

	@RequestMapping("/update/{id}")
	public String update(@PathVariable int id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		model.addAttribute("kind", kindService.findOne(id));
		model.addAttribute("page", kindService.findAll(filter, pageable));
//		model.addAttribute("categories", categoryService.findAll());
		show(model, pageable, filter);
		return "admin-kind";
	}
	
	@RequestMapping(method=POST)
	public String save(@ModelAttribute("kind") @Valid Kind kind ,BindingResult br, SessionStatus status,Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		if(br.hasErrors()){
			model.addAttribute("categories", categoryService.findAll());
			model.addAttribute("page", kindService.findAll(filter, pageable));
			return "admin-kind";
		}
		kindService.save(kind);
		status.setComplete();
		return "redirect:/admin/kind"+getParams(pageable, filter);
	}
}
