package nl.youngcapital.atm.consumables;

import java.util.Random;

public class ConsumableGenerator {
	private static final String[] DEFAULT_EFFECTS = { "heal", "heal over time" };
	private static final String[] DEFAULT_TYPES = { "potion", "food" };

	private static final Random RAN = new Random();

	static public Consumable generateRandomConsumable() {
		String effect = getEffect();
		String type = getType();
		int price = getPrice(type);
		String name = getName(effect, type, price);

		return new Consumable(name, effect, type, price);
	}

	static private int getPrice(String type) {
		if (type.equals("heal")) {
			return RAN.nextInt(2) + 10;
		} else if (type.equals("heal over time")) {
			return 5;
		}
		return 0;
	}

	static private String getType() {
		int typePick = RAN.nextInt(DEFAULT_TYPES.length);
		return DEFAULT_TYPES[typePick];
	}

	static private String getEffect() {
		int consumablePick = RAN.nextInt(DEFAULT_EFFECTS.length);
		return DEFAULT_EFFECTS[consumablePick];
	}

	static private String getName(String effect, String type, int price) {
		StringBuilder sb = new StringBuilder();

		if (effect.equals("heal")) {

			sb.append("Healing ");

		} else if (effect.equals("heal over time")) {
			sb.append("Regenerating ");

		}
		
		sb.append(type);
		return sb.toString();
	}
}
