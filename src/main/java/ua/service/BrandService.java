package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.dto.form.BasicFilter;
import ua.entity.Brand;

public interface BrandService {

	Brand findOne(int id);
	
	List<Brand> findAll();
	
	void save(Brand brand);
	
	void delete(int id);

	Brand findByBrand(String brand);
	
	Page <Brand> findAll(BasicFilter filter, Pageable pageable);

}
