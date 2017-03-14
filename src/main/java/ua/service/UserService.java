package ua.service;

import java.security.Principal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;

import ua.dto.form.ItemFilter;
import ua.entity.Item;
import ua.entity.User;

public interface UserService {
	
	void save(User user);

	Page<Item> findAll(ItemFilter filter, Pageable pageable);

	void saveItem(Principal principal, @PathVariable int id);
	
	void saveItem(int id);

	List<User> findBuy(Pageable pageable);

	User findUserBuy(Principal principal);

	List<Item> findByCategoryId(int id);

	void deleteItem(Principal principal, int id);

	
}
