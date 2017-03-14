package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.dto.form.ItemFilter;
import ua.dto.form.ItemForm;
import ua.entity.Item;

public interface ItemService {
	
	Item findById(int id);
	
	List<Item> findAll();
	
	void save(ItemForm itemForm);
	
	void delete(int id);

	Item findByItem(String item);

	void save(Item item);
	
	ItemForm findOne(int id);
	
	

//	Item findAll(ItemFilter filter, Pageable pageable);

	Page<Item> findAll(ItemFilter filter, Pageable pageable);

	List<Item> findByCategoryId(int id);

	
}
