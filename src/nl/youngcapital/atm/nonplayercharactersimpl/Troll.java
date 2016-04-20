package nl.youngcapital.atm.nonplayercharactersimpl;

import java.util.ArrayList;
import java.util.Random;

import nl.youngcapital.atm.combatsystem.FightableCharacter;
import nl.youngcapital.atm.effects.Effect;
import nl.youngcapital.atm.elements.Element;
import nl.youngcapital.atm.itembehaviour.Lootable;
import nl.youngcapital.atm.itemgenerator.ItemGenerator;
import nl.youngcapital.atm.nonplayercharacters.NonPlayableCharacter;

public class Troll implements NonPlayableCharacter, FightableCharacter, Lootable {
	private int healthPoints;
	private ArrayList<Element> elements;
	private ArrayList<Effect> effects;
	private String description;
	private int armor;
	private Object item;
	
	private final static String DEFAULT_DESCRIPTION="IT IS A CUTE TROLL!"; 
	private static final int MAX_HEALTH_POINTS = 41;
	private static final int MIN_HEALTH_POINTS = 20;
	private static final int MAX_DAMAGE = 41;
	private static final int MIN_DAMAGE = 20;
	private static final Random RAN = new Random();

	public Troll() {
		this.description = DEFAULT_DESCRIPTION;
		healthPoints = RAN.nextInt(MAX_HEALTH_POINTS - MIN_HEALTH_POINTS) + MIN_HEALTH_POINTS;
		effects = new ArrayList<>();
		elements = new ArrayList<>();
		armor = 14;
		item = ItemGenerator.generateItem();
	}
	
	public Troll(String description) {
		this();
		this.description = description; 
		
	}

	@Override
	public int getDamage() {
		

		return RAN.nextInt(MAX_DAMAGE - MIN_DAMAGE) + MIN_DAMAGE;
	}
	
	@Override
	public void dealDamage(int damage) {
		
		this.healthPoints = healthPoints - damage;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public ArrayList<Element> getElements() {
		
		return elements;
	}

	@Override
	public int getHealth() {
		return this.healthPoints;
	}
	
	@Override
	public void setEffect(Effect effect) {
		this.effects.add(effect);
	}

	@Override
	public ArrayList<Effect> getEffects() {
		return this.effects;
	}

	@Override
	public int getArmor() {
		return armor;
	}

	@Override
	public boolean isFriendly() {

		return false;
	}

	@Override
	public Object take() {
		
		item = true;
		return item;
	}

}
