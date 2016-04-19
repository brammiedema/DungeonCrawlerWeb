package nl.youngcapital.atm.elements;


public abstract class Element {
	private Element strengthElement;
	private Element weaknessElement;
	private String name;
	
	public Element(){
		
	}
	
	public Element(String name, Element weaknessElement, Element strengthElement){
		this.strengthElement = strengthElement;
		this.weaknessElement = weaknessElement;
		this.name = name;
	}
	
	public abstract Element getStrengthElement();
	
	public abstract Element getWeaknessElement();
	
	public abstract String getName();
	
}
