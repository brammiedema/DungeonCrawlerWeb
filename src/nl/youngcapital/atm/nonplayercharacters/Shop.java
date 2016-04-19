package nl.youngcapital.atm.nonplayercharacters;

import nl.youngcapital.atm.armor.Armor;
import nl.youngcapital.atm.inventory.Inventory;
import nl.youngcapital.atm.weapon.Weapon;

public interface Shop {
		
	public Weapon buyWeapon(String weaponName);
	
	public Armor buyArmor(String armorName);
	
	public Armor buyConsumable(String consumableName);
	
	public void sellWeapon(Inventory inventory);
	
	public void sellArmor(Inventory inventory);
	
	public void sellConsumable(Inventory inventory);
		
}
