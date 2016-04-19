package nl.youngcapital.atm.combatsystem;

import java.util.ArrayList;

import nl.youngcapital.atm.effects.Effect;
import nl.youngcapital.atm.elements.Element;

public interface FightableCharacter {
	
	
	public void setEffect(Effect effect);
	
	/**
	 * Returns current health
	 * 
	 * @return
	 */
	public int getArmor();
	
	
	/**
	 * Returns current health
	 * 
	 * @return
	 */
	public int getHealth();
	
	/**
	 * Gets damage dealt by this fightable character.
	 * 
	 * @return
	 */
	public int getDamage();
	
	/**
	 * Deals damage to this character.
	 * 
	 * @return
	 */
	public void dealDamage(int damage);
	
	
	/**
	 * Retrieves the elements from this fightable character
	 * 
	 * @return
	 */
	public ArrayList<Element> getElements();
	
	/**
	 * Retrieves the effects applicable to this fightable character
	 * 
	 * @return
	 */
	public ArrayList<Effect> getEffects();

	
	
}
