package nl.youngcapital.atm.nonplayercharacters;

import java.util.ArrayList;

import nl.youngcapital.atm.combatsystem.FightableCharacter;
import nl.youngcapital.atm.effects.Effect;
import nl.youngcapital.atm.elements.Element;

public interface NonPlayableCharacter extends FightableCharacter{
	
	public boolean isFriendly();
		
	public String getDescription();
	
	public ArrayList<Element> getElements();
	
	public ArrayList<Effect> getEffects();
}
