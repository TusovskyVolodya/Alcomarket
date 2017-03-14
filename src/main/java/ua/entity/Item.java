package ua.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "item")
public class Item extends AbstractEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	private Brand brand;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Country country;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private GiftBox giftBox;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Kind kind;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Category category;
	
	@Column(name = "_item")
	private String item;
	
	@Column(name = "_price")
	private BigDecimal price;
	
	@Column(name = "_capasity")
	private BigDecimal capasity;
	
	@Column(name = "_eduranse")
	private int eduranse;
	
	@Column(name = "version", nullable = true)
	private Integer version;

	@ManyToMany(mappedBy="items" ) 
	private List<User> users = new ArrayList<>();
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public GiftBox getGiftBox() {
		return giftBox;
	}

	public void setGiftBox(GiftBox giftBox) {
		this.giftBox = giftBox;
	}

	public Kind getKind() {
		return kind;
	}

	public void setKind(Kind kind) {
		this.kind = kind;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getCapasity() {
		return capasity;
	}

	public void setCapasity(BigDecimal capasity) {
		this.capasity = capasity;
	}

	public int getEduranse() {
		return eduranse;
	}

	public void setEduranse(int eduranse) {
		this.eduranse = eduranse;
	}

}
