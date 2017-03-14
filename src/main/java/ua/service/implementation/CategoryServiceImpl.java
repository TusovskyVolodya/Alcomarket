package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.dto.form.BasicFilter;
import ua.entity.Category;
import ua.repository.CategoryRepository;
import ua.service.CategoryService;
import ua.service.specification.CategorySpecification;
@Service
public class CategoryServiceImpl implements CategoryService{
	

		@Autowired
		private CategoryRepository repository;
		
		@Override
		@Transactional(readOnly=true)
		public Category findOne(int id) {
			return repository.findOne(id);
		}

		@Override
		@Transactional(readOnly=true)
		public List<Category> findAll() {
			return repository.findAll();
		}

		@Override
		public void save(Category category ) {
			repository.save(category);
			
		}
		@Override
		public Category findOne(String category) {
			return repository.findByCategory(category);
		}
		
//		@Override
//		public Category findOne(int id) {
//			return repository.findOne(id);
//		}
		

		@Override
		public void delete(int id) {
			repository.delete(id);
			
		}

		@Override
		public Category findByCategory(String category) {
			return repository.findByCategory(category);
		}
		
		@Override
		public Page<Category> findAll(BasicFilter filter, Pageable pageable) {
			return repository.findAll(new CategorySpecification(filter), pageable);
		}

}
