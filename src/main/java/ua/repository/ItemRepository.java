package ua.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>,JpaSpecificationExecutor<Item>{

	Item findByItem(String item);
	
	@Query(value="SELECT i FROM Item i LEFT JOIN FETCH i.country  LEFT JOIN FETCH i.kind  LEFT JOIN FETCH i.category  LEFT JOIN FETCH i.giftBox")
	List<Item> findAll();


	@Query("SELECT i FROM Item i LEFT JOIN FETCH i.country LEFT JOIN FETCH i.brand  LEFT JOIN FETCH i.kind LEFT JOIN FETCH i.category  LEFT JOIN FETCH i.giftBox WHERE i.id=:id")
			Item findOne(@Param("id")int id);

	
	@Query(value="SELECT i FROM Item i LEFT JOIN FETCH i.country LEFT JOIN FETCH i.kind  LEFT JOIN FETCH i.category  LEFT JOIN FETCH i.giftBox",
			countQuery="SELECT count(i.id) FROM Item i")
	Page<Item> findAll(Pageable pageable);
	
	@Query("SELECT i FROM Item i LEFT JOIN FETCH i.country LEFT JOIN FETCH i.category  WHERE i.category.id = ?1")
	List<Item> findByCategoryId(int id);

	
}
