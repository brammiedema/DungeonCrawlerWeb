package nl.youngcapital.atm.effects;

import nl.youngcapital.atm.elements.Element;
import nl.youngcapital.atm.elements.Fire;

public class Burn extends Effect implements HealthEffect, DamageOverTime{
	private int duration;
	private String name;
	private int effectProc;
	
	private static final int DAMAGE = 4; 
	private static final Element element =  new Fire();
	private static final int DEFAULT_DURATION = 5;
	private static final  String NAME = "Burn";
	private static final int EFFECT_PROC_CHANCE = 5;
	
	public Burn(){
		super(DEFAULT_DURATION, NAME, EFFECT_PROC_CHANCE);
	}
	
	public Burn(int duration, String name, int effectProc) {
		super(duration, name, effectProc);
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
		return 4;
	}

	@Override
	public int getDotTickDamage() {
		return DAMAGE;
	}

	@Override
	public Element getElement() {
		return element;
	}

}
