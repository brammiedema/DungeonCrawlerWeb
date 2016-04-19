package nl.youngcapital.atm.elements;

public class Air extends Element {
	private Element strengthElement;
	private Element weaknessElement;
	
	static final private String NAME = "Air";
	static final private Element DEFAULT_STRENGHT_ELEMENT = new Fire();
	static final private Element DEFAULT_WEAKNESS_ELEMENT = new Earth();
	
	public Air() {
		super(NAME, DEFAULT_WEAKNESS_ELEMENT, DEFAULT_STRENGHT_ELEMENT);
	}

	public Air(String name, Element weaknessElement, Element strengthElement) {
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
