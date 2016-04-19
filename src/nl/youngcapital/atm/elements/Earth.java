package nl.youngcapital.atm.elements;

public class Earth extends Element {
	private Element strengthElement;
	private Element weaknessElement;
	static final private String NAME = "Earth";
	
	static final private Element DEFAULT_STRENGHT_ELEMENT = new Air();
	static final private Element DEFAULT_WEAKNESS_ELEMENT = new Water();

	public Earth() {
		super(NAME, DEFAULT_WEAKNESS_ELEMENT, DEFAULT_STRENGHT_ELEMENT);
	}

	public Earth(String name, Element weaknessElement, Element strengthElement) {
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
