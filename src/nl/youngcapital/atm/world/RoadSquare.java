package nl.youngcapital.atm.world;

import nl.youngcapital.atm.events.Event;
import nl.youngcapital.atm.events.RandomEventGenerator;

public class RoadSquare extends Square {

	final private static String DEFAULT_DESCRIPTION = "You are on a road.";
	private String description;
	private Event event;

	public RoadSquare() {
		this.description = DEFAULT_DESCRIPTION;
		event =  RandomEventGenerator.generateRandomEvent();
	}

	public RoadSquare(String description) {
		this();
		this.description = description;

	}

	public String getDescription() {

		if (description.equals(null)) {
			return DEFAULT_DESCRIPTION;
		} else {
			return this.description;
		}
	}

	@Override
	public Event getEvent() {

		return event;
	}

	@Override
	public boolean hasEvent() {
		if (event == null) {
			return false;
		}
		return true;
	}
}
