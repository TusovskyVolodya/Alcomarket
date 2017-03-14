package ua.service.implementation;

import java.security.Principal;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import ua.dto.form.ItemFilter;
import ua.entity.Item;
import ua.entity.Role;
import ua.entity.User;
import ua.repository.ItemRepository;
import ua.repository.UserRepository;
import ua.service.ItemService;
import ua.service.UserService;
import ua.service.specification.ItemSpecification;
@Service("userDetailsService")
public class UserServiceImpl implements UserDetailsService, UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private ItemService itemService;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		return userRepository.findByUsername(username);
	}

	@Override
	public void save(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		user.setRole(Role.ROLE_USER);
		userRepository.save(user);
	}
	
	@PostConstruct
	public void admin(){
		User user = userRepository.findByUsername("admin");
		if(user==null){
			user = new User();
			user.setEmail("");
			user.setPassword(encoder.encode("admin"));
			user.setRole(Role.ROLE_ADMIN);
			user.setUsername("admin");
			userRepository.save(user);
		}
	}

	@Override
	public Page<Item> findAll(ItemFilter filter, Pageable pageable) {
		Page<Item> items = itemRepository.findAll(new ItemSpecification(filter),pageable);
		return items;
	}
	
	

	@Override
	@Transactional
	public void saveItem(Principal principal, @PathVariable int id) {
		User user=userRepository.findByUsername(principal.getName());
		Item item=itemRepository.findOne(id);
		user.setItems(item);
		userRepository.save(user);
	}


	@Override
	public List<User> findBuy(Pageable pageable) {
		return userRepository.findAllBuy(pageable);
	}

	@Override
	public void saveItem(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findUserBuy(Principal principal) {
		if(principal!=null){
			String item=principal.getName();		
			return userRepository.findAllitems(item);}
			return new User();

	}

	@Override
	public List<Item> findByCategoryId(int id) {
		return itemRepository.findByCategoryId(id);
	}

	@Override 
	@Transactional 
	public void deleteItem(Principal principal,int id){ 
	User user = userRepository.findByUsername(principal.getName()); 
	Item item = itemService.findById(id); 
	// user.getBooks().remove(id); 
	Iterator <Item> iter= user.getItems().iterator(); 
	while(iter.hasNext()){ 
	if(iter.next().equals(item)){ 
	iter.remove(); 
	break;
	} 
	
	}
	
	}

	

	}

