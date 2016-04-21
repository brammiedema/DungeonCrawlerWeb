package nl.youngcapital.atm.player;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class PlayerData {
	private String name;
	private int x;
	private int y;
	private int z;
	private int healthPoints = 100;
	
	private CharacterSheet cs;

	protected static final int MAX_DAMAGE = 3;
	protected static final int MIN_DAMAGE = 2;
	protected static final int BASE_ARMOR = 2;

	private Long id;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public int getHealthPoints() {
		return healthPoints;
	}

	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	@Column(unique = true, nullable=false)
	public String getName() {
		return name;
	}
	
	@OneToOne(cascade = {CascadeType.ALL})
	public CharacterSheet getCs() {
		return cs;
	}

	public void setCs(CharacterSheet cs) {
		this.cs = cs;
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
	
	

}
