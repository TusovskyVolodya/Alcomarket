package ua.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "eduranse")
public class Eduranse extends AbstractEntity {
	
	
	private int eduranse;

	public int getEduranse() {
		return eduranse;
	}

	public void setEduranse(int eduranse) {
		this.eduranse = eduranse;
	}

}
