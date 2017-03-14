package ua.service;

import java.util.List;

import ua.entity.Capasity;

public interface CapasityService {
    
	Capasity findOne(int id);
	
	List<Capasity> findAll();
	
	void save(Capasity capasity);
	
	void delete(int id);
	
	
}
