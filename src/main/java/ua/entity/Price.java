package ua.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "price")
public class Price  extends AbstractEntity {
	
	private int price;

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}
