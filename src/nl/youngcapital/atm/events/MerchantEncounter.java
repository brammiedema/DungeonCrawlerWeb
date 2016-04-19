package nl.youngcapital.atm.events;

import nl.youngcapital.atm.nonplayercharacters.NonPlayableCharacter;
import nl.youngcapital.atm.nonplayercharactersimpl.Merchant;

public class MerchantEncounter extends Event implements Encounter{
	private String description;
	private Merchant merchant;
	final static private String DEFAULT_DESCRIPTION= "A friendly merchant shows his friendly face!";
	
	public MerchantEncounter() {
		this.description = DEFAULT_DESCRIPTION;
		merchant = new Merchant();
		
	}
	
	public MerchantEncounter(String description) {
		this();
		this.description = description;
		
	}

	@Override
	public boolean isFriendly() {
		return true;
	}

	@Override
	public String getDescription() {
		
		return description;
	}
	
	@Override
	public NonPlayableCharacter getNonPlayableCharacter() {
		
		 return this.merchant;
	}

	
}
