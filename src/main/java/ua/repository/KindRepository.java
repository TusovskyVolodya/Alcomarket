package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.entity.Kind;

public interface KindRepository extends JpaRepository<Kind, Integer>,  JpaSpecificationExecutor<Kind>{
	
	@Query("SELECT k FROM Kind k LEFT JOIN FETCH k.category WHERE k.id=:id")
	Kind findOne(@Param("id")int id);


	Kind findByKind(String kind);

}
