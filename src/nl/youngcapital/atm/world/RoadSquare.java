package nl.youngcapital.atm.world;

import java.util.Random;

import nl.youngcapital.atm.events.Event;
import nl.youngcapital.atm.events.MerchantEncounter;

public class RoadSquare extends Square {

	final private static String DEFAULT_DESCRIPTION = "You are on a road.";
	private String description;
	private Event event;

	public RoadSquare() {
		this.description = DEFAULT_DESCRIPTION;

		Random ran = new Random();

		if ((ran.nextInt() % 3) == 1) {
			switch (ran.nextInt(2)) {
			case 0:
				event = new MerchantEncounter();
				break;
			case 1:
				event = new MerchantEncounter();
				break;
			case 2:
				event = new MerchantEncounter();
				break;
			default:
				break;
			}
		} else {
			event = null;
		}
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
