package ua.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "giftBox")
public class GiftBox extends AbstractEntity {
	
	@Column(name = "_giftBox")
	 private String giftBox;

	public String getGiftBox() {
		return giftBox;
	}

	public void setGiftBox(String giftBox) {
		this.giftBox = giftBox;
	}

	@OneToMany(mappedBy = "giftBox")
	private List<Item> items = new ArrayList<>();
}
