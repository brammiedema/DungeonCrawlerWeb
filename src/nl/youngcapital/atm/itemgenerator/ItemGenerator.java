package nl.youngcapital.atm.itemgenerator;

import java.util.Random;

import nl.youngcapital.atm.armor.ArmorGenerator;
import nl.youngcapital.atm.consumables.ConsumableGenerator;
import nl.youngcapital.atm.weapon.WeaponGenerator;

public class ItemGenerator {
	
	final private static Random RAN = new Random();
	
	static public Object generateItem() {
		int itemType = RAN.nextInt(3);
		Object item;
		switch (itemType) {
		case 0:
			item = ArmorGenerator.generateRandomArmor();
			break;
		case 1:
			item = ConsumableGenerator.generateRandomConsumable();
			break;
		case 2:
			item = WeaponGenerator.generateRandomWeapon();
			break;

		default:
			item = null;
			break;
		}
		return item;
		
	}	
}
