package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.Price;
import ua.repository.PriceRepository;
import ua.service.PriceService;

@Service
public class PriceServiceImpl implements PriceService{
	
		@Autowired
		private PriceRepository repository;
		
		@Override
		@Transactional(readOnly=true)
		public Price findOne(int id) {
			return repository.findOne(id);
		}

		@Override
		@Transactional(readOnly=true)
		public List<Price> findAll() {
			return repository.findAll();
		}

		@Override
		public void save(Price price ) {
			repository.save(price);
			
		}

		@Override
		public void delete(int id) {
			repository.delete(id);
			
		}

}
