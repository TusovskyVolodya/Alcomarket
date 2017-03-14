package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.dto.form.BasicFilter;
import ua.entity.Kind;

public interface KindService {
	
	Kind findOne(int id);
	
	List<Kind> findAll();
	
	void save(Kind kind);
	
	void delete(int id);

	Kind findByKind(String kind);
	
	Page <Kind> findAll(BasicFilter filter, Pageable pageable);
}
