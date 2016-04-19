package nl.youngcapital.atm.world;

import nl.youngcapital.atm.events.Event;

public abstract class Square {
	
	private String description;

	public Square(){
		super();
	}
	
	public Square(String description){
		this.description = description;
	}
	
	public abstract String getDescription();
	
	public abstract boolean hasEvent();
	
	public abstract Event getEvent();
}
