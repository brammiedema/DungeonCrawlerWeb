package nl.youngcapital.atm.weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeaponGenerator {

	private static final String[] ELEMENT_TYPES = { "fire", "water", "air", "earth" };
	private static final String[] EFFECTS = { "crushed", "Bleed", "Burn" };
	private static final String[] WEAPON_TYPES = { "sword", "mace" };

	private static Random RAN = new Random();

	/**
	 * Use this in production
	 */
	public WeaponGenerator() {
		super();
	}

	/**
	 * for test purposes
	 * 
	 * @param seed
	 */
	public WeaponGenerator(long seed) {
		RAN = new Random(seed);
	}

	static public Weapon generateRandomWeapon() {
		List<String> elements = new ArrayList<>();
		List<String> effects = new ArrayList<>();

		elements = getElementTypes();
		effects = getEffectNames();

		String weaponType = getWeaponType();

		int maxDmg = getMaxDmg(weaponType);
		int minDmg = getMinDmg(weaponType);
		int price = getPrice(weaponType);

		String name = getName(weaponType, elements, effects, maxDmg);

		return new Weapon(name, weaponType, maxDmg, minDmg, price, elements, effects);

	}

	static private String getEffectName() {
		int efIndex = RAN.nextInt(10);

		if (efIndex < 3) {
			return EFFECTS[efIndex];

		}

		return null;
	}

	static private List<String> getEffectNames() {
		int d20 = RAN.nextInt(20);
		List<String> effects = new ArrayList<String>();
		if (d20 > 15) {
			effects.add(getEffectName());
		}
		if (d20 > 12) {
			effects.add(getEffectName());
		}
		if (d20 > 7) {
			effects.add(getEffectName());
		}

		return null;
	}

	static private int getPrice(String weaponType) {
		int price = 0;

		if (weaponType.equals("sword")) {
			price = 10 + RAN.nextInt(5);
		} else if (weaponType.equals("mace")) {
			price = 13 + RAN.nextInt(3);
		}

		return price;
	}

	static private int getMaxDmg(String weaponType) {

		int maxDmg = 0;

		if (weaponType.equals("sword")) {
			maxDmg = 10 + RAN.nextInt(5);
		} else if (weaponType.equals("mace")) {
			maxDmg = 9 + RAN.nextInt(9);
		}

		return maxDmg;
	}

	static private int getMinDmg(String weaponType) {
		int minDmg = 0;

		if (weaponType.equals("sword")) {
			minDmg = 7 + RAN.nextInt(5);
		} else if (weaponType.equals("mace")) {
			minDmg = 2 + RAN.nextInt(7);
		}

		return minDmg;
	}
	/**
	 * creates a name based on other properties of the weapon.
	 * 
	 * @param weaponType
	 * @param elements
	 * @param effects
	 * @param maxDmg
	 * @return
	 */
	static private String getName(String weaponType, List<String> elements, List<String> effects, int maxDmg) {
		StringBuilder name = new StringBuilder();

		if (weaponType.equals("sword")) {

			if (maxDmg > 13) {
				name.append(" sharp ");
			}

			if (elements.size() > 2) {
				name.append(" elemental ");
			}

			name.append(" sword");

		} else if (weaponType.equals(" mace")) {
			if (maxDmg > 15) {
				name.append(" mighty ");

			}
			if (elements.size() > 2) {
				name.append(" doom ");
			}
			name.append(" mace");

		}

		return name.toString();
	}

	static private String getWeaponType() {
		return WEAPON_TYPES[RAN.nextInt(WEAPON_TYPES.length)];
	}

	static private String getElementType() {
		int elIndex = RAN.nextInt(10);

		if (elIndex < 4) {
			return ELEMENT_TYPES[elIndex];

		}

		return null;
	}

	static private List<String> getElementTypes() {
		int d20 = RAN.nextInt(20);

		List<String> effects = new ArrayList<String>();

		if (d20 > 15) {
			effects.add(getElementType());
		}
		if (d20 > 12) {
			effects.add(getElementType());
		}
		if (d20 > 7) {
			effects.add(getElementType());
		}

		return effects;
	}
}
