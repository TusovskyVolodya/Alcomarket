package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.entity.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer>,JpaSpecificationExecutor<Brand>{
	  
	@Query("SELECT b FROM Brand b LEFT JOIN FETCH b.country WHERE b.id=:id")
	Brand findOne(@Param("id")int id);

	Brand findByBrand(String brand);
}
