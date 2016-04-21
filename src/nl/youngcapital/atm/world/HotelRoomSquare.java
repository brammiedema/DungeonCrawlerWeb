package nl.youngcapital.atm.world;

import nl.youngcapital.atm.events.Event;
import nl.youngcapital.atm.events.RandomEventGenerator;

public class HotelRoomSquare extends Square{
	final private static String DEFAULT_DESCRIPTION = "You are in Harry the turtle's hotel room, he looks at you with beady eyes.";
	
	private String description;
	private Event event;
	
	public HotelRoomSquare(){
		this.description =  DEFAULT_DESCRIPTION;
		
		event =  RandomEventGenerator.generateRandomEvent();
	}
	
	public HotelRoomSquare(String description ){
		this();
		this.description=description;
		
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
