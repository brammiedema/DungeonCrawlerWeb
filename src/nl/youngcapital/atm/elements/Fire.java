package nl.youngcapital.atm.elements;

public class Fire extends Element{
	private Element strengthElement;
	private Element weaknessElement;
	final static private String NAME = "Fire";
	
	static final private Element DEFAULT_STRENGHT_ELEMENT = new Water();
	static final private Element DEFAULT_WEAKNESS_ELEMENT = new Air();
	
	public Fire(){
		super(NAME, DEFAULT_WEAKNESS_ELEMENT, DEFAULT_STRENGHT_ELEMENT);
	}
	
	public Fire(String name, Element weaknessElement, Element strengthElement){
		super(name, weaknessElement, strengthElement);
	}
	
	@Override
	public Element getStrengthElement() {
		
		return strengthElement;
	}

	@Override
	public Element getWeaknessElement() {
		// TODO Auto-generated method stub
		return weaknessElement;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return NAME;
	}

}
