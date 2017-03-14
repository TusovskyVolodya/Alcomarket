package ua.controller.admin;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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

import ua.dto.form.ItemFilter;
import ua.dto.form.ItemForm;
import ua.editor.BrandEditor;
import ua.editor.CategoryEditor;
import ua.editor.CountryEditor;
import ua.editor.GiftBoxEditor;
import ua.editor.KindEditor;
import ua.entity.Brand;
import ua.entity.Category;
import ua.entity.Country;
import ua.entity.GiftBox;
import ua.entity.Kind;
import ua.service.BrandService;
import ua.service.CategoryService;
import ua.service.CountryService;
import ua.service.GiftBoxService;
import ua.service.ItemService;
import ua.service.KindService;
import ua.validator.ItemValidator;

@Controller
@RequestMapping("/admin/item")
@SessionAttributes(names="item")
public class ItemController {

	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private BrandService brandService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private GiftBoxService giftBoxService;
	
	@Autowired
	private KindService kindService;
	
	
	
	@InitBinder("item")
	protected void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(Brand.class, new BrandEditor(brandService));
		binder.registerCustomEditor(Category.class, new CategoryEditor(categoryService));
		binder.registerCustomEditor(Country.class, new CountryEditor(countryService));
		binder.registerCustomEditor(GiftBox.class, new GiftBoxEditor(giftBoxService));
		binder.registerCustomEditor(Kind.class, new KindEditor(kindService));
		binder.setValidator(new ItemValidator());
	}
	
	@ModelAttribute("item")
	public ItemForm getForm(){
		return new ItemForm();
	}
	
	@ModelAttribute("filter")
	public ItemFilter getFilter(){
		return new ItemFilter();
	}
	
	
	@RequestMapping("/update/{id}")
	public String update(@PathVariable int id , Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") ItemFilter filter){
		model.addAttribute("item", itemService.findOne(id));
		model.addAttribute("page", itemService.findAll(filter, pageable));
		model.addAttribute("brands",brandService.findAll());
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("countries", countryService.findAll());
		model.addAttribute("giftBoxs", giftBoxService.findAll());
		model.addAttribute("kinds", kindService.findAll());
		show(model, pageable, filter);
		return "admin-item";
	}
	
	@RequestMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") ItemFilter filter){
		model.addAttribute("page", itemService.findAll(filter, pageable));
		model.addAttribute("brands",brandService.findAll());
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("countries", countryService.findAll());
		model.addAttribute("giftBoxs", giftBoxService.findAll());
		model.addAttribute("kinds", kindService.findAll());
		return "admin-item";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id, @PageableDefault Pageable pageable, @ModelAttribute("filter") ItemFilter filter){
		itemService.delete(id);
		return "redirect:/admin/item"+getParams(pageable, filter);
	}
	
	@RequestMapping(method=POST)
	public String save(@ModelAttribute("item") @Valid ItemForm item, BindingResult br, Model model, SessionStatus sessionStatus, @PageableDefault Pageable pageable, @ModelAttribute("filter") ItemFilter filter){
		if(br.hasErrors()){
			model.addAttribute("page", itemService.findAll(filter, pageable));
			model.addAttribute("brands",brandService.findAll());
			model.addAttribute("categories", categoryService.findAll());
			model.addAttribute("countries", countryService.findAll());
			model.addAttribute("giftBoxs", giftBoxService.findAll());
			model.addAttribute("kinds", kindService.findAll());
			
			return "admin-item";
		}
		itemService.save(item);
		sessionStatus.setComplete();
		return "redirect:/admin/item"+getParams(pageable, filter);
		
	}
	
	private String getParams(Pageable pageable, ItemFilter filter){
		StringBuilder buffer = new StringBuilder();
		buffer.append("?page=");
		buffer.append(String.valueOf(pageable.getPageNumber()+1));
		buffer.append("&size=");
		buffer.append(String.valueOf(pageable.getPageSize()));
		if(pageable.getSort()!=null){
			buffer.append("&sort=");
			Sort sort = pageable.getSort();
			sort.forEach((order)->{
				buffer.append(order.getProperty());
				if(order.getDirection()!=Direction.ASC)
				buffer.append(",desc");
			});
		}
		if(!filter.getSearch().isEmpty()){
			buffer.append("&search=");
			buffer.append(filter.getSearch());
		}
		if(!filter.getMaxPrice().isEmpty()){
			buffer.append("&maxPrice=");
			buffer.append(filter.getMaxPrice());
		}
		if(!filter.getMinPrice().isEmpty()){
			buffer.append("&minPrice=");
			buffer.append(filter.getMinPrice());
		}
		for(Integer id : filter.getBrandIds()){
			buffer.append("&brandIds=");
			buffer.append(id);
		}
		for(Integer id : filter.getCountryIds()){
			buffer.append("&countryIds=");
			buffer.append(id);
		}
		for(Integer id : filter.getCategoryIds()){
			buffer.append("&categoryIds=");
			buffer.append(id);
		}
		for(Integer id : filter.getGiftBoxIds()){
			buffer.append("&giftBoxIds=");
			buffer.append(id);
		}
		for(Integer id : filter.getKindIds()){
			buffer.append("&kindIds=");
			buffer.append(id);
		}
		
		return buffer.toString();
	}
}
