package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.dto.form.BasicFilter;
import ua.entity.Category;

public interface CategoryService {
	
	Category findOne(int id);
	
	List<Category> findAll();
	
	void save(Category category);
	
	void delete(int id);

	Category findByCategory(String category);
	
	Page <Category> findAll(BasicFilter filter, Pageable pageable);

	Category findOne(String category);
	

}
