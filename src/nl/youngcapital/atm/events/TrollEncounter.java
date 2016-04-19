package nl.youngcapital.atm.events;

import nl.youngcapital.atm.nonplayercharacters.NonPlayableCharacter;
import nl.youngcapital.atm.nonplayercharactersimpl.Troll;

public class TrollEncounter extends Event implements Encounter{
	private Troll troll;
	private String description;
	final static private String DEFAULT_DESCRIPTION= "A fierce troll appears infront of you!";
	
	public TrollEncounter() {
		
		this.description = DEFAULT_DESCRIPTION;
		troll = new Troll();
	}
	
	public TrollEncounter(String description) {
		this();
		this.description = description;
		
	}

	@Override
	public boolean isFriendly() {
		return false;
	}
	
	@Override
	public String getDescription(){
		
		return description;
	}
	
	@Override
	public NonPlayableCharacter getNonPlayableCharacter() {
		return troll;
	}

}
