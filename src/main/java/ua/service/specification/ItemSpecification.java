package ua.service.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.dto.form.ItemFilter;
import ua.entity.Item;

public class ItemSpecification implements Specification<Item>{
	
	private final ItemFilter filter;
	
	private final List<Predicate> predicates = new ArrayList<>();
	
	public ItemSpecification(ItemFilter filter) {
		this.filter = filter;
	}
	
	
	private void filterByBrand(Root<Item> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		if(!filter.getBrandIds().isEmpty()){
			predicates.add(root.get("brand").in(filter.getBrandIds()));
		}
	}
	
	private void filterByCountry(Root<Item> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		if(!filter.getCountryIds().isEmpty()){
			predicates.add(root.get("country").in(filter.getCountryIds()));
		}
	}
	
	private void filterByCategory(Root<Item> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		if(!filter.getCategoryIds().isEmpty()){
			predicates.add(root.get("category").in(filter.getCategoryIds()));
		}
	}
	
	private void filterByGiftBox(Root<Item> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		if(!filter.getGiftBoxIds().isEmpty()){
			predicates.add(root.get("giftBox").in(filter.getGiftBoxIds()));
		}
	}
	
	private void filterByKind(Root<Item> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		if(!filter.getKindIds().isEmpty()){
			predicates.add(root.get("kind").in(filter.getKindIds()));
		}
	}
	
	private void filterByPrice(Root<Item> root, CriteriaQuery<?> query, CriteriaBuilder cb){
		if(filter.getMax()!=null&&filter.getMin()!=null){
			predicates.add(cb.between(root.get("price"), filter.getMin(), filter.getMax()));
		}else if(filter.getMax()!=null){
			predicates.add(cb.lessThanOrEqualTo(root.get("price"), filter.getMax()));
		}else if(filter.getMin()!=null){
			predicates.add(cb.greaterThanOrEqualTo(root.get("price"), filter.getMin()));
		}
	}
	
	private void filterBySearch(Root<Item> root, CriteriaQuery<?> query, CriteriaBuilder cb){
		if(!filter.getSearch().isEmpty()){
			predicates.add(cb.like(root.get("item"), filter.getSearch()+"%"));
		}
	}
	
	private void fetch(Root<Item> root, CriteriaQuery<?> query){
		if(query.getResultType()!=Long.class){
			root.fetch("country", JoinType.LEFT);
			root.fetch("brand", JoinType.LEFT);
		}
	}
	
//	private void fetchKind(Root<Item> root, CriteriaQuery<?> query){
//		if(query.getResultType()!=Long.class){
//			root.fetch("category", JoinType.LEFT);
//			root.fetch("kind", JoinType.LEFT);
//		}
//	}

	@Override
	public Predicate toPredicate(Root<Item> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		fetch(root, query);
		query.distinct(true);
		filterBySearch(root, query, cb);
		filterByPrice(root, query, cb);
		filterByBrand(root, query, cb);
		filterByCountry(root, query, cb);
		filterByCategory(root, query, cb);
		filterByGiftBox(root, query, cb);
		filterByKind(root, query, cb);
		if(predicates.isEmpty())return null;
		Predicate[] array = new Predicate[predicates.size()];
		predicates.toArray(array);
		return cb.and(array);
	}
	
	

	}


