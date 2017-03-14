package ua.service.implementation;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.dto.form.ItemFilter;
import ua.dto.form.ItemForm;
import ua.entity.Item;
import ua.repository.BrandRepository;
import ua.repository.CategoryRepository;
import ua.repository.CountryRepository;
import ua.repository.GiftBoxRepository;
import ua.repository.ItemRepository;
import ua.repository.KindRepository;
import ua.service.FileWriter;
import ua.service.FileWriter.Folder;
import ua.service.ItemService;
import ua.service.specification.ItemSpecification;
@Service
public class ItemServiceImpl implements ItemService{

		@Autowired
		private ItemRepository itemRepository;
		@Autowired
		private BrandRepository brandRepository;
		@Autowired
		private CategoryRepository categoryRepository;
		@Autowired
		private CountryRepository countryRepository;
		@Autowired
		private GiftBoxRepository giftBoxRepository;
		@Autowired
		private KindRepository kindRepository;
		
		@Autowired
		private FileWriter fileWriter;
		
//		@Override
//		@Transactional(readOnly=true)
//		public Item findOne(int id) {
//			return itemRepository.findOne(id);
//		}

		@Override
		@Transactional(readOnly=true)
		public List<Item> findAll() {
			return itemRepository.findAll();
		}

		@Override
		public void save(Item item ) {
			itemRepository.save(item);
			
		}

		@Override
		public void delete(int id) {
			itemRepository.delete(id);
			
		}

		@Override
		public Item findByItem(String item) {
			return itemRepository.findByItem(item);
		}

		@Override
		@Transactional
		public void save(ItemForm itemForm) {
			Item item = new Item();
			
			item.setId(itemForm.getId());
			item.setCategory(itemForm.getCategory());
			item.setCountry(itemForm.getCountry());
			item.setBrand(itemForm.getBrand());
			item.setKind(itemForm.getKind());
			item.setItem(itemForm.getItem());
			item.setPrice(new BigDecimal(itemForm.getPrice().replace(',', '.')));
			item.setCapasity(new BigDecimal(itemForm.getCapasity().replace(',', '.')));
			item.setEduranse(Integer.valueOf(itemForm.getEduranse()));
			itemRepository.saveAndFlush(item);
			if(fileWriter.write(Folder.ITEM, itemForm.getFile(), item.getId())){
				if(item.getVersion()==null)item.setVersion(0);
				else item.setVersion(item.getVersion()+1);
			}
			itemRepository.save(item);
		}

		@Override
		public Page<Item> findAll(ItemFilter filter, Pageable pageable) {
			System.out.println("---------------------------------------------------------------");
			Page<Item> items = itemRepository.findAll(new ItemSpecification(filter),pageable);
			System.out.println("---------------------------------------------------------------");
			return items;
		}
		
			@Override
			@Transactional(readOnly=true)
			public ItemForm findOne(int id) { 
				Item item = itemRepository.findOne(id); 
				ItemForm itemForm = new ItemForm(); 
				
				itemForm.setId(item.getId());
				itemForm.setCategory(item.getCategory());
				itemForm.setCountry(item.getCountry());
				itemForm.setBrand(item.getBrand());
				itemForm.setKind(item.getKind());
				itemForm.setItem(item.getItem());
				itemForm.setPrice(String.valueOf(item.getPrice()));
				itemForm.setCapasity(String.valueOf(item.getCapasity()));
				itemForm.setEduranse(String.valueOf(item.getEduranse()));
				return itemForm; 
				}

			
			@Override
			public List<Item> findByCategoryId(int id) {
				return itemRepository.findByCategoryId(id);
			}

			@Override
			public Item findById(int id) {
				return itemRepository.findOne(id);
			}
			

			
		
		}


