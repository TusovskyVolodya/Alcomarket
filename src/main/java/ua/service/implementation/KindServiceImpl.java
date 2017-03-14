package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.dto.form.BasicFilter;
import ua.entity.Kind;
import ua.repository.KindRepository;
import ua.service.KindService;
import ua.service.specification.KindSpecification;

@Service
public class KindServiceImpl implements KindService{

		@Autowired
		private KindRepository repository;
		
		@Override
		@Transactional(readOnly=true)
		public Kind findOne(int id) {
			return repository.findOne(id);
		}

		@Override
		@Transactional(readOnly=true)
		public List<Kind> findAll() {
			return repository.findAll();
		}

		@Override
		public void save(Kind kind ) {
			repository.save(kind);
			
		}

		@Override
		public void delete(int id) {
			repository.delete(id);
			
		}

		@Override
		public Kind findByKind(String kind) {
			return repository.findByKind(kind);
		}

		@Override
		public Page<Kind> findAll(BasicFilter filter, Pageable pageable) {
			return repository.findAll(new KindSpecification(filter), pageable);
		}

}
