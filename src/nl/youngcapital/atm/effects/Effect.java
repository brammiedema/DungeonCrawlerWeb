package nl.youngcapital.atm.effects;

import nl.youngcapital.atm.elements.Element;

public abstract class Effect {
	
	private int duration; 
	private String name;
	private int effectProc;
	
	public Effect(){
		super();
	}
	
	public Effect(int duration, String name, int effectProcChance){
		this.duration = duration;
		this.name = name;
		this.effectProc = effectProcChance;
		
	}
	
	public abstract Element getElement();
	
	public abstract int getDuration();
	
	public abstract String getName();
	
	public abstract int getEffectProc();
	
	public abstract void substractDuration();
	
	public abstract void addDuration();
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setDuration(int duration){
		this.duration = duration;
	}
	
	public void setEffectProc(int effectProc){
		this.effectProc = effectProc;
	}
		
}
