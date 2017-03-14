package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.dto.form.BasicFilter;
import ua.entity.GiftBox;
import ua.repository.GiftBoxRepository;
import ua.service.GiftBoxService;
import ua.service.specification.GiftBoxSpecification;
@Service
public class GiftBoxServiceImpl implements GiftBoxService{
 
		@Autowired
		private GiftBoxRepository repository;
		
		@Override
		@Transactional(readOnly=true)
		public GiftBox findOne(int id) {
			return repository.findOne(id);
		}

		@Override
		@Transactional(readOnly=true)
		public List<GiftBox> findAll() {
			return repository.findAll();
		}

		@Override
		public void save(GiftBox giftBox ) {
			repository.save(giftBox);
			
		}

		@Override
		public void delete(int id) {
			repository.delete(id);
			
		}

		@Override
		public GiftBox findByGiftBox(String giftBox) {
			return repository.findByGiftBox(giftBox);
		}

		@Override
		public Page<GiftBox> findAll(BasicFilter filter, Pageable pageable) {
			return repository.findAll(new GiftBoxSpecification(filter), pageable);
		}

}
