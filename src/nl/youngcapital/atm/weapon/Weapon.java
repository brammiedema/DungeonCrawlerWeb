package nl.youngcapital.atm.weapon;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class Weapon {

	private String name;
	private String type;
	private int maxDmg;
	private int minDmg;
	private int price;
	private long id;

	private boolean equiped;

	private List<String> effects;
	private List<String> elements;
	
	public Weapon(){
		
	}
	
	/**
	 * Generates an equiped weapon with the stats given
	 * 
	 * @param name
	 * @param type
	 * @param maxDmg
	 * @param minDmg
	 * @param price
	 * @param elements
	 * @param effects
	 */
	public Weapon(String name, String type, int maxDmg, int minDmg, int price, List<String> elements,
			List<String> effects, boolean equiped) {
		super();
		this.name = name;
		this.type = type;
		this.maxDmg = maxDmg;
		this.minDmg = minDmg;
		this.price = price;
		this.elements = elements;
		this.effects = effects;
		this.equiped = equiped;
	}

	/**
	 * Generates a weapon with the stats given
	 * 
	 * @param name
	 * @param type
	 * @param maxDmg
	 * @param minDmg
	 * @param price
	 * @param elements
	 * @param effects
	 */
	public Weapon(String name, String type, int maxDmg, int minDmg, int price, List<String> elements,
			List<String> effects) {
		super();
		this.name = name;
		this.type = type;
		this.maxDmg = maxDmg;
		this.minDmg = minDmg;
		this.price = price;
		this.elements = elements;
		this.effects = effects;
		this.equiped =  false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getMaxDmg() {
		return maxDmg;
	}

	public void setMaxDmg(int maxDmg) {
		this.maxDmg = maxDmg;
	}

	public int getMinDmg() {
		return minDmg;
	}

	public void setMinDmg(int minDmg) {
		this.minDmg = minDmg;
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

	@LazyCollection(LazyCollectionOption.FALSE)
	@ElementCollection
	@CollectionTable(name = "Effects", joinColumns = @JoinColumn(name = "weapon_id"))
	@Column(name = "effects")
	public List<String> getEffects() {
		return effects;
	}
	
	
	public void setEffects(List<String> effects) {
		this.effects = effects;
	}

	@LazyCollection(LazyCollectionOption.FALSE)
	@ElementCollection
	@CollectionTable(name = "Elements", joinColumns = @JoinColumn(name = "weapon_id"))
	@Column(name = "elements")
	public List<String> getElements() {
		return elements;
	}

	public void setElements(List<String> elements) {
		this.elements = elements;
	}
	

	public boolean isEquiped() {
		return equiped;
	}

	public void setEquiped(boolean equiped) {
		this.equiped = equiped;
	}

}
