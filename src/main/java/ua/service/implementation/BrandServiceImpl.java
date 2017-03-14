package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.dto.form.BasicFilter;
import ua.entity.Brand;
import ua.repository.BrandRepository;
import ua.service.BrandService;
import ua.service.specification.BrandSpecification;

@Service
public class BrandServiceImpl implements BrandService{

	@Autowired
	private BrandRepository repository;
	
	
	@Override
	@Transactional(readOnly=true)
	public Brand findOne(int id) {
		return repository.findOne(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Brand> findAll() {
		return repository.findAll();
	}

	@Override
	public void save(Brand brand) {
		repository.save(brand);
		
	}

	@Override
	public void delete(int id) {
		repository.delete(id);
		
	}

	@Override
	public Brand findByBrand(String brand) {
		return repository.findByBrand(brand);
	}

	@Override
	public Page<Brand> findAll(BasicFilter filter, Pageable pageable) {
		return repository.findAll(new BrandSpecification(filter), pageable);
	}

}
