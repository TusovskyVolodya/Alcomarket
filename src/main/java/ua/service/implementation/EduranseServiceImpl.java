package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.Eduranse;
import ua.repository.EduranseRepository;
import ua.service.EduranseService;
@Service
public class EduranseServiceImpl implements EduranseService{ 
 
		@Autowired
		private EduranseRepository repository;
		
		@Override
		@Transactional(readOnly=true)
		public Eduranse findOne(int id) {
			return repository.findOne(id);
		}

		@Override
		@Transactional(readOnly=true)
		public List<Eduranse> findAll() {
			return repository.findAll();
		}

		@Override
		public void save(Eduranse eduranse ) {
			repository.save(eduranse);
			
		}

		@Override
		public void delete(int id) {
			repository.delete(id);
			
		}

}
