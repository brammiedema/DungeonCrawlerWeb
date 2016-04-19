package nl.youngcapital.atm.combatsystem;

import java.util.ArrayList;

import nl.youngcapital.atm.effects.Effect;
import nl.youngcapital.atm.effects.HealthEffect;
import nl.youngcapital.atm.elements.Element;

public class CombatSystem {

	private static CombatSystem cb;
	private final static double ATTACK_WEAKNESS_MODIFIER = 2;
	private final static double ATTACK_STRENGTH_MODIFIER = 2;
	private final static double EFFECT_WEAKNESS_MODIFIER = 2;
	private final static double EFFECT_STRENGTH_MODIFIER = 2;

	private CombatSystem() {

	}

	public static CombatSystem getInstance() {
		if (cb == null) {
			cb = new CombatSystem();
		}
		return cb;
	}

	/**
	 * {@link FightableCharacter} attacker fights {@link FightableCharacter}
	 * defender defender
	 * 
	 * @param attacker
	 * @param defender
	 */
	public boolean fight(FightableCharacter attacker, FightableCharacter defender) {

		int dmg = (int) (attacker.getDamage() * getAttackModifier(attacker.getElements(), defender.getElements()));
		defender.dealDamage((int) (dmg * (1 - (getDamageReductionPercentage(defender.getArmor()) / 100))));

		resolveEffects(defender);

		return (attacker.getHealth() > 0) && (defender.getHealth() > 0);

	}

	/**
	 * retrieves the damage modifier according to weaknesses and strengths of
	 * attacks.
	 * 
	 * @param attackerElements
	 * @param defenderElements
	 * @return
	 */
	private double getAttackModifier(ArrayList<Element> attackerElements, ArrayList<Element> defenderElements) {
		double mod = 1;

		for (Element ae : attackerElements) {
			for (Element de : defenderElements) {
				if (ae.getName().equals(de.getWeaknessElement().getName())) {
					mod = mod * ATTACK_STRENGTH_MODIFIER;
				} else if (ae.getName().equals(de.getStrengthElement().getName())) {
					mod = mod / ATTACK_WEAKNESS_MODIFIER;
				}
			}

		}

		return mod;
	}

	/**
	 * returns percentage of damage defense
	 * 
	 * @param armor
	 * @return
	 */
	private int getDamageReductionPercentage(int armor) {

		return (int) ((armor * 3) * 0.75);
	}

	private void resolveEffects(FightableCharacter defender) {

		for (Effect effect : defender.getEffects()) {
			if (effect.getDuration() > 0) {
				effect.substractDuration();
				if (effect instanceof HealthEffect) {
					HealthEffect he = (HealthEffect) effect;
					for (Element element : defender.getElements()) {
						if (element.getWeaknessElement().equals(effect.getElement())) {
							defender.dealDamage((int) (he.getHealthChangeValue() * EFFECT_STRENGTH_MODIFIER));

						} else if (element.getStrengthElement().equals(effect.getElement())) {
							defender.dealDamage((int) (he.getHealthChangeValue() * EFFECT_WEAKNESS_MODIFIER));

						} else {
							defender.dealDamage(he.getHealthChangeValue());

						}
					}
				}
			}
		}
	}

}
