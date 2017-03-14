package ua.controller.user;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.math.BigDecimal;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import ua.dto.form.ItemFilter;
import ua.entity.Item;
import ua.entity.User;
import ua.service.CategoryService;
import ua.service.ItemService;
import ua.service.UserService;

@Controller
public class IndexController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private CategoryService categoryService;

	@ModelAttribute("filter")
	public ItemFilter getFilter(){
		return new ItemFilter();
	}
	
	@RequestMapping("/")
	public String index(Principal principal,Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") ItemFilter filter) {
		if (principal != null)
			System.out.println(principal.getName());
		model.addAttribute("page", userService.findAll(filter,pageable));
		model.addAttribute("categories", categoryService.findAll());
		return "user-index";
	}

	@RequestMapping("/admin")
	public String admin() {
		return "admin-admin";
	}

	@RequestMapping("/login")
	public String login() {
		return "user-login";
	}

	@RequestMapping("/registration")
	public String registration(Model model) {
		model.addAttribute("userForm", new User());
		return "user-registration";
	}

	@RequestMapping(value = "/registration", method = POST)
	public String registration(@ModelAttribute User user) {
		userService.save(user);
		return "redirect:/login";
	}
	

	@RequestMapping("/basketUser")
	public String BasketUser(Model model, @PageableDefault Pageable pageable,Principal principal ){
		model.addAttribute("user", userService.findUserBuy(principal));
		BigDecimal price =new BigDecimal(0);
//		for(Item item:userService.findUserBuy(principal).getItems()){
//			price=price.add(item.getPrice());
//		}
		model.addAttribute("s",price);
		
		return "user-basketUser";
	}
	
	@RequestMapping("/item/{id}")
	public String showItem( @PathVariable int id,Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") ItemFilter filter){
			model.addAttribute("item", itemService.findOne(id));
		return "user-item";
	}
	
	
	@RequestMapping("/buy/{id}")
	public String buy(@PathVariable int id,Principal principal){
			userService.saveItem(principal,id);
			return "redirect:/"; 
	}

	@RequestMapping("/basket")
	public String Basket(Model model, @PageableDefault Pageable pageable ){
	
		model.addAttribute("items", userService.findBuy(pageable));
	return "user-basket";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id,Principal principal){
			userService.deleteItem(principal,id);
			return "redirect:/"; 
	}
	
	@RequestMapping("/category/{id}")
	public String category(@PathVariable int id, Model model){
		model.addAttribute("category", categoryService.findOne(id));
		model.addAttribute("items", itemService.findByCategoryId(id));
		return "user-category";
	}
	
	@RequestMapping("/basket/deleteItem/{id}") 
	public String deletebuy(@PathVariable int id, Principal principal){ 
	userService.deleteItem(principal,id); 
	return "redirect:/basketUser"; 
	}
	
}
