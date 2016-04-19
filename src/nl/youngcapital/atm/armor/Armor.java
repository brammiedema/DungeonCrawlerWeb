package nl.youngcapital.atm.armor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/**
 * Armor bean class
 * 
 * 
 * @author Student
 */
@Entity
public class Armor {
	
	private String name;
	private int armor;
	private String type;
	private int price;
	private long id;
	private boolean equiped;
	
	public Armor(String name, int armor, String type, int price, boolean equiped) {
		this.name = name;
		this.armor = armor;
		this.type = type;
		this.price = price;
		this.equiped = equiped;
		
	}
	
	public Armor(String name, int armor, String type, int price) {
		this.name = name;
		this.armor = armor;
		this.type = type;
		this.price = price;
		this.equiped =  false;
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public boolean isEquiped() {
		return equiped;
	}

	public void setEquiped(boolean equiped) {
		this.equiped = equiped;
	}
}
