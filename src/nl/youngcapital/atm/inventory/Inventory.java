package nl.youngcapital.atm.inventory;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import nl.youngcapital.atm.armor.Armor;
import nl.youngcapital.atm.consumables.Consumable;
import nl.youngcapital.atm.player.CharacterSheet;
import nl.youngcapital.atm.weapon.Weapon;

@Entity
public class Inventory {

	private CharacterSheet cs;

	private List<Weapon> weapons = new ArrayList<>();
	private List<Armor> armors = new ArrayList<>();
	private List<Consumable> consumables = new ArrayList<>();

	private long id;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = {CascadeType.ALL})
	@JoinColumn(name = "inventory_id")
	public List<Weapon> getWeapons() {
		return weapons;
	}

	public void setWeapons(List<Weapon> weapons) {
		this.weapons = weapons;
	}
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = {CascadeType.ALL})
	@JoinColumn(name = "inventory_id")
	public List<Armor> getArmors() {
		return armors;
	}

	public void setArmors(List<Armor> armors) {
		this.armors = armors;
	}
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = {CascadeType.ALL}, fetch=FetchType.EAGER)
	@JoinColumn(name = "inventory_id")
	public List<Consumable> getConsumables() {
		return consumables;
	}

	public void setConsumables(List<Consumable> consumables) {
		this.consumables = consumables;
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

	@OneToOne(mappedBy = "inventory")
	public CharacterSheet getCs() {
		return cs;
	}

	public void setCs(CharacterSheet cs) {
		this.cs = cs;
	}

}
