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
import ua.entity.GiftBox;
import ua.service.GiftBoxService;
import ua.validator.GiftBoxValidator;

@Controller
@RequestMapping("/admin/giftBox")
@SessionAttributes(names="giftBox")
public class GiftBoxController {
	
	@Autowired
	private GiftBoxService giftBoxService;
	
	@ModelAttribute("giftBox")
	public GiftBox getGiftBox(){
		return new GiftBox();
	}
	
	@ModelAttribute("filter")
	public BasicFilter getFilter(){
		return new BasicFilter();
	}
	
	@RequestMapping
	public String show(Model model,  @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		model.addAttribute("page", giftBoxService.findAll(filter, pageable));
		return "admin-giftBox";
	}
	
	@InitBinder("giftBox")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new GiftBoxValidator(giftBoxService));
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		giftBoxService.delete(id);
		return "redirect:/admin/giftBox"+getParams(pageable, filter);
	}
	

	@RequestMapping("/update/{id}")
	public String update(@PathVariable int id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		model.addAttribute("giftBox", giftBoxService.findOne(id));
		model.addAttribute("page", giftBoxService.findAll(filter, pageable));
		return "admin-giftBox";
	}
	
	@RequestMapping(method=POST)
	public String save(@ModelAttribute("giftBox") @Valid GiftBox giftBox ,BindingResult br, SessionStatus status,Model model,  @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		if(br.hasErrors()){
			model.addAttribute("page", giftBoxService.findAll(filter, pageable));
			return "admin-giftBox";
		}
		giftBoxService.save(giftBox);
		status.setComplete();
		return "redirect:/admin/giftBox"+getParams(pageable, filter);
	}
	
}
