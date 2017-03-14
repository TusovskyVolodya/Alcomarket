package ua.service;

import java.util.List;

import ua.entity.Eduranse;

public interface EduranseService {
  
	 Eduranse findOne(int id);
	 
	 List<Eduranse> findAll();
	 
	 void save(Eduranse eduranse);
	 
	 void delete (int id);
	 
}
