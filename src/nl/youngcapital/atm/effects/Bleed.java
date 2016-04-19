package nl.youngcapital.atm.effects;

import nl.youngcapital.atm.elements.Element;

public class Bleed extends Effect implements HealthEffect{
	private int duration;
	private String name;
	private int effectProc;
	private static final int DAMAGE = 2;
	
	private static final int DEFAULT_DURATION = 3;
	private final static String NAME = "bleed";
	private static final int EFFECT_PROC_CHANCE = 11;
	
	public Bleed(){
		super(DEFAULT_DURATION, NAME, EFFECT_PROC_CHANCE);
	}
	
	public Bleed(int duration, String name, int effectProcChance) {
		super(duration, name, effectProcChance);

	}

	@Override
	public int getDuration() {
		return duration;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getEffectProc() {
		return effectProc;
	}

	@Override
	public void substractDuration() {
		this.duration =- 1;
	}

	@Override
	public void addDuration() {
		this.duration =+ DEFAULT_DURATION;
	}

	@Override
	public int getHealthChangeValue() {
		return DAMAGE;
	}

	@Override
	public Element getElement() {
		return null;
	}
	
}
