package nl.youngcapital.atm.events;

import nl.youngcapital.atm.nonplayercharacters.NonPlayableCharacter;

public interface Encounter{
	
	public boolean isFriendly();
	
	public String getDescription();
	
	public NonPlayableCharacter getNonPlayableCharacter();
}
