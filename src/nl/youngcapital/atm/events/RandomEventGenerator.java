package nl.youngcapital.atm.events;

import java.util.Random;

public class RandomEventGenerator {
	final private static Random RAN = new Random();

	static public Event generateRandomEvent() {
		
		Event event = null;
		
		if ((RAN.nextInt() % 3) == 1) {
			switch (RAN.nextInt(4)) {
			case 0:
				event = new MerchantEncounter();
				break;
			case 1:
				event = new TrollEncounter();
				break;
			case 2:
				event = new TrollEncounter();
				break;
			case 3:
				event = new ChestEvent();
				break;
			default:
				break;
			}
		}

		return event;
	}
}
