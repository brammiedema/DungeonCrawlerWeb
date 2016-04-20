package nl.youngcapital.atm.events;

import nl.youngcapital.atm.itembehaviour.Container;
import nl.youngcapital.atm.itembehaviour.Lootable;
import nl.youngcapital.atm.itemgenerator.ItemGenerator;

public class ChestEvent extends Event implements Container, Lootable{
	private String description;
	private double probability;
	private boolean open = false;
	private boolean empty = false;
	private Object item;
	

	
	final static private  String NAME = "chest";
	final static private String DEFAULT_DESCRIPTION = "You see a wooden chest.";
	
	public ChestEvent() {
		description = DEFAULT_DESCRIPTION;
		item = ItemGenerator.generateItem();
		if(item == null){
			empty = true;
		}
	}

	public ChestEvent(String description) {
		this();
		this.description = description;
	}

	@Override
	public String getDescription() {
		return description;
	}

	public String getName() {
		return NAME;
	}

	public double getProbability() {
		return probability;
	}

	public void setProbability(double probability) {
		this.probability = probability;
	}

	@Override
	public boolean isOpen() {
		open = true;
		return open;
		
	}

	@Override
	public Object take() {
		if (empty){
			return null;
		}
		empty = true;
	
		return item;
		
	}

	@Override
	public boolean isEmpty() {
		return empty;
		
	}
}
