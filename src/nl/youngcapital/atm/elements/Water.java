package nl.youngcapital.atm.elements;

public class Water extends Element {
	private Element strengthElement;
	private Element weaknessElement;
	static final private String NAME = "Water";
	
	static final private Element DEFAULT_STRENGHT_ELEMENT = new Earth();
	static final private Element DEFAULT_WEAKNESS_ELEMENT = new Fire();

	public Water() {
		super(NAME, DEFAULT_WEAKNESS_ELEMENT, DEFAULT_STRENGHT_ELEMENT);
	}

	public Water(String name, Element weaknessElement, Element strengthElement) {
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
