package nl.youngcapital.atm.player;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import nl.youngcapital.atm.inventory.Inventory;

@Entity
public class CharacterSheet {

	private PlayerData playerData;
	private long id;
	private Inventory inventory;
	
	public CharacterSheet() {
		super();
		inventory = new Inventory();
		
	}

	@OneToOne(mappedBy = "cs") // mappedBy is property op PlayerData
	public PlayerData getPlayerData() {
		return playerData;
	}

	public void setPlayerData(PlayerData playerData) {
		this.playerData = playerData;
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

	
	@OneToOne(cascade = {CascadeType.ALL})
	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}



}
