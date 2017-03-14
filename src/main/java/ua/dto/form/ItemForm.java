package ua.dto.form;

import org.springframework.web.multipart.MultipartFile;

import ua.entity.Brand;
import ua.entity.Category;
import ua.entity.Country;
import ua.entity.GiftBox;
import ua.entity.Kind;


public class ItemForm {

	private int id;

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	private String item;

	private String capasity;

	private String eduranse;

	private String price;

	private Category category;
	
	private Country country;
	
	private Brand brand;
	
	private Kind kind;
	
	private GiftBox giftBox;

	private MultipartFile file;
	
	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	

	public String getCapasity() {
		return capasity;
	}

	public void setCapasity(String capasity) {
		this.capasity = capasity;
	}

	public String getEduranse() {
		return eduranse;
	}

	public void setEduranse(String eduranse) {
		this.eduranse = eduranse;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Kind getKind() {
		return kind;
	}

	public void setKind(Kind kind) {
		this.kind = kind;
	}

	public GiftBox getGiftBox() {
		return giftBox;
	}

	public void setGiftBox(GiftBox giftBox) {
		this.giftBox = giftBox;
	}

	

	
}
