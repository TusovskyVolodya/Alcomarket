package ua.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.entity.Item;
import ua.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	@Query("SELECT u FROM User u WHERE u.username=:username")
	User findByUsername(@Param("username")String username);
	
	@Query(value="SELECT i FROM Item i LEFT JOIN FETCH i.country LEFT JOIN FETCH i.category LEFT JOIN FETCH i.brand LEFT JOIN FETCH i.kind LEFT JOIN FETCH i.giftBox",
			countQuery="SELECT count(i.id) FROM Item i")
	Page<User> findAll(Pageable pageable);

	
	@Query("SELECT u FROM User u LEFT JOIN FETCH u.items i LEFT JOIN FETCH i.brand Where u.items is not empty")
	List<User> findAllBuy(Pageable pageable);

	@Query("UPDATE User u SET u.items=:item")
	void saveItem(@Param("item")Item item);
	
	@Query(value="SELECT u FROM User u  JOIN FETCH u.items i Where u.username=:item")
	User findAllitems(@Param("item") String item);

	
	
//	SET FOREIGN_KEY_CHECKS=0;
	
	

	

	

	

	

	

}
