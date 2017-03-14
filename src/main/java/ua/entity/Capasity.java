package ua.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "capasity")
public class Capasity extends AbstractEntity {

 int capasity;

public int getCapasity() {
	return capasity;
}

public void setCapasity(int capasity) {
	this.capasity = capasity;
}
 
}
