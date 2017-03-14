package ua.service;

import java.util.List;

import ua.entity.Price;

public interface PriceService {
	
	Price findOne(int id);
	
	List<Price> findAll();
	
	void save(Price price);
	
	void delete(int id);
}
