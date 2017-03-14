package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.dto.form.BasicFilter;
import ua.entity.GiftBox;

public interface GiftBoxService {
	
	GiftBox findOne(int id);
	
	List<GiftBox> findAll();
	
	void save(GiftBox giftBox);
	
	void delete(int id);

	GiftBox findByGiftBox(String giftBox);

	Page <GiftBox> findAll(BasicFilter filter, Pageable pageable);
}
