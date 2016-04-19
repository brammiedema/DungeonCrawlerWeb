package nl.youngcapital.atm.events;

public abstract class Event {

	private String name;
	private double probability;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public abstract String getDescription() ;
	
	public double getProbability() {
		return probability;
	}
	public void setProbability(double probability) {
		this.probability = probability;
	}
	
}
