package nl.youngcapital.atm.effects;

import nl.youngcapital.atm.elements.Element;

public class Crushed extends Effect {
	private static final int DEFAULT_DURATION = 2;
	private static final int DEFAULT_PROC = 2;
	private static final String DEFAULT_NAME = "Crushed";

	private int duration;

	public Crushed(){
		this.duration =  DEFAULT_PROC;
	}

	@Override
	public Element getElement() {
		return null;
	}

	@Override
	public int getDuration() {
		return duration;
	}

	@Override
	public String getName() {
		return DEFAULT_NAME;
	}

	@Override
	public int getEffectProc() {
		
		return DEFAULT_PROC;
	}

	@Override
	public void substractDuration() {
		this.duration--;

	}

	@Override
	public void addDuration() {
		this.duration += DEFAULT_DURATION;
		

	}

}
