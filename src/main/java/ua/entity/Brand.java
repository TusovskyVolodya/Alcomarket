package ua.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "brand")
public class Brand extends AbstractEntity {
	
	@Column(name = "_brand")
	private String brand;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "_country")
	Country country;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}


	@OneToMany(mappedBy = "brand")
	private List<Item> items = new ArrayList<>();

	@Override
	public String toString() {
		return brand ;
	}
	
	
}
