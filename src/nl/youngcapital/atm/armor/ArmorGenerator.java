package nl.youngcapital.atm.armor;

import java.util.Random;

public class ArmorGenerator {
	private static final String[] ARMOR_TYPES = { "mail", "plate", "mithrel" };

	private static Random RAN = new Random();

	/**
	 * for test purposes
	 * 
	 * @param seed
	 */
	public ArmorGenerator(long seed) {
		RAN = new Random(seed);
	}

	/**
	 * Use this in production
	 */
	public ArmorGenerator() {
		super();
	}

	/**
	 * 
	 * @return {@link Armor}
	 */
	static public Armor generateRandomArmor() {

		
		String type = getType();
		int armor = getArmor(type);
		int price = getPrice(type);
		String name = getName(type, armor, price);

		return new Armor(name, armor, type, price);

	}

	static private String getName(String type, int armor, int price) {
		StringBuilder sb = new StringBuilder();
		
		if(type.equals("mail")){
			sb.append(" chainmail");
			
		} else if(type.equals("plate")){
			sb.append(" platemail");
			
		} else if(type.equals("mithrel")){
			sb.append("mithrel armor");
		}
		
		
		return sb.toString();
	}

	static private int getArmor(String type) {
		int armor = 0;
		
		if(type.equals("mail")){
			armor =  16;
			
		} else if(type.equals("plate")){
			armor =  29;
			
		} else if(type.equals("mithrel")){
			armor = 35;
		}
		
		return armor;
	}

	static private String getType() {
		return ARMOR_TYPES[RAN.nextInt(3)];
	}

	static private int getPrice(String type) {
		int price = 0;
		
		if(type.equals("mail")){
			price =  15;
			
		} else if(type.equals("plate")){
			price =  21;
			
		} else if(type.equals("mithrel")){
			price = 27;
		}
		
		return price;
	}

}
