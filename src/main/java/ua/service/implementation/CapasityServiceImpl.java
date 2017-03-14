package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.Capasity;
import ua.repository.CapasityRepository;
import ua.service.CapasityService;

@Service
public class CapasityServiceImpl implements CapasityService{

		@Autowired
		private CapasityRepository repository;
		
		@Transactional(readOnly=true)
		public Capasity findOne(int id) {
			return repository.findOne(id);
		}

		@Transactional(readOnly=true)
		public List<Capasity> findAll() {
			return repository.findAll();
		}
		@Override
		public void save(Capasity capasity) {
			repository.save(capasity);
			
		}
		@Override
		public void delete(int id) {
			repository.delete(id);
			
		}

	}

