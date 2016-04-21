package nl.youngcapital.atm.world;

import nl.youngcapital.atm.events.Event;
import nl.youngcapital.atm.events.RandomEventGenerator;

public class PlainsSquare extends Square{
	final private static String DEFAULT_DESCRIPTION = "You find yourself in the middle of a stretch of plains.";
	private String description;
	private Event event;
	
	public PlainsSquare() {
		this.description=DEFAULT_DESCRIPTION;
		
		event =  RandomEventGenerator.generateRandomEvent();
	}
	
	public PlainsSquare(String description){
		this();
		this.description = description;
	}
	
	public String getDescription(){
		
		if(description.equals(null)){
			return DEFAULT_DESCRIPTION;
		}else{
			return this.description;
		}
	}

	@Override
	public Event getEvent() {

		return event;
	}
	
	@Override
	public boolean hasEvent() {
		if(event == null){
			return false;
		}
		return true;
	}

}
