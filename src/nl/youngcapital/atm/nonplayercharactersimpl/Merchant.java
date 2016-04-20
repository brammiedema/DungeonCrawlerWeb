package nl.youngcapital.atm.nonplayercharactersimpl;

import java.util.ArrayList;
import java.util.Random;

import nl.youngcapital.atm.armor.Armor;
import nl.youngcapital.atm.armor.ArmorGenerator;
import nl.youngcapital.atm.combatsystem.FightableCharacter;
import nl.youngcapital.atm.consumables.Consumable;
import nl.youngcapital.atm.consumables.ConsumableGenerator;
import nl.youngcapital.atm.effects.Effect;
import nl.youngcapital.atm.elements.Element;
import nl.youngcapital.atm.inventory.Inventory;
import nl.youngcapital.atm.inventory.InventoryManager;
import nl.youngcapital.atm.itembehaviour.Lootable;
import nl.youngcapital.atm.itemgenerator.ItemGenerator;
import nl.youngcapital.atm.nonplayercharacters.NonPlayableCharacter;
import nl.youngcapital.atm.nonplayercharacters.Shop;
import nl.youngcapital.atm.weapon.Weapon;
import nl.youngcapital.atm.weapon.WeaponGenerator;

public class Merchant implements NonPlayableCharacter, Shop, FightableCharacter, Lootable {
	private Inventory inventory;
	private int value;
	private int healthPoints;
	private String description;
	private ArrayList<Element> elements;
	private ArrayList<Effect> effects;
	private int armor;
	private Object item;
	
	
	private static final int MAXVALUE = 50;
	private static final int MINVALUE = 30;
	private final static String DEFAULT_DESCRIPTION = "a merchant selling valuebles.";
	private static final int MAX_HEALTH_POINTS = 20;
	private static final int MIN_HEALTH_POINTS = 16;
	private static final int MAX_DAMAGE = 10;
	private static final int MIN_DAMAGE = 5;
	private static final Random RAN = new Random();

	
	
	public Merchant(String description) {
		this();
		this.description = description;

	}

	public Merchant() {
		this.description = DEFAULT_DESCRIPTION;
		healthPoints = RAN.nextInt(MAX_HEALTH_POINTS - MIN_HEALTH_POINTS) + MIN_HEALTH_POINTS;
		inventory = new Inventory();
		effects = new ArrayList<>();
		elements = new ArrayList<>();
		armor = 4;
		item = ItemGenerator.generateItem();
		fillInventory();
	}

	/**
	 * fills inventory arraylist with random items
	 */
	private void fillInventory() {
		this.value = RAN.nextInt(MAXVALUE - MINVALUE) + MINVALUE;
		InventoryManager im = InventoryManager.getInstance();
		int value = 0;

		while (this.value >= value) {

			int itemTypePick = RAN.nextInt(5) % 3;

			if (itemTypePick == 0) {

				switch (itemTypePick) {
				case 0:
					Weapon weapon = WeaponGenerator.generateRandomWeapon();
					im.addItem(inventory, weapon);

					value += weapon.getPrice();
					break;

				case 1:
					Armor armor = ArmorGenerator.generateRandomArmor();
					im.addItem(inventory, armor);

					value += armor.getPrice();
					break;

				default:
					Consumable consumable = ConsumableGenerator.generateRandomConsumable();
					im.addItem(inventory, consumable);

					value += consumable.getPrice();
					break;
				}
			}
		}
		this.value = value;
	}

	public Inventory getInventory() {
		return this.inventory;
	}

	public int getValue() {
		return this.value;
	}

	@Override
	public void dealDamage(int damage) {

		this.healthPoints = healthPoints - damage;
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public ArrayList<Element> getElements() {

		return this.elements;
	}

	@Override
	public int getDamage() {
		return RAN.nextInt(MAX_DAMAGE - MIN_DAMAGE) + MIN_DAMAGE;
	}

	@Override
	public boolean isFriendly() {
		return true;
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
	public int getHealth() {
		return this.healthPoints;
	}

	@Override
	public int getArmor() {
		return armor;
	}

	
	@Override
	public Object take() {
		item = true;
		return item;
	}
}
