package nl.youngcapital.atm.world;

import nl.youngcapital.atm.events.Event;

public class LemonSquare extends Square {
	final private static String DEFAULT_DESCRIPTION = "You see a giant lemon blocking your way, the way is blocked return to where you came from.";
	private String description;
	private Event event;

	public LemonSquare() {
		this.description = DEFAULT_DESCRIPTION;
	}

	public LemonSquare(String description) {
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
