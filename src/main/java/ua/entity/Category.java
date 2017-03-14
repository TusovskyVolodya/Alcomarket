package ua.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category extends AbstractEntity {

	@Column(name = "_category")
	 private String category;

	public String getName() {
		return category;
	}

	public void setName(String category) {
		this.category = category;
	}
	
	@OneToMany(mappedBy = "category")
	private List<Item> items = new ArrayList<>();

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	@OneToMany(mappedBy = "category")
	List<Kind> kinds = new ArrayList<>();

	}


