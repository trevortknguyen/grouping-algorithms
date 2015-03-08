package matchmaker;

import java.util.LinkedList;

import engine.Personality;

public class PersonalityRule {
	public static LinkedList<PersonalityRule> ruleList;
	
	private String regexA;
	private String regexB;
	int effect;
	
	public PersonalityRule(String regexA, String regexB, int effect) {
		this.regexA = regexA;
		this.regexB = regexB;
		this.effect = effect;
		
		ruleList.add(this);
	}
	
	private boolean isApplicable(Personality a, Personality b) {
		return a.toString().matches(regexA) && b.toString().matches(regexB) ||
			b.toString().matches(regexA) && a.toString().matches(regexB);
	}
	
	public int getCompatibility(Personality a, Personality b) {
		if (!isApplicable(a, b)) return 0;
		int rate = 0;
		
		if (a.toString().matches(regexA)) {
			if (regexA.matches("[EI]...")) rate += Math.abs(a.getMind()) / 50 * effect;
			if (regexA.matches(".[NS]..")) rate += Math.abs(a.getEnergy()) / 50 * effect;
			if (regexA.matches("..[TF].")) rate += Math.abs(a.getNature()) / 50 * effect;
			if (regexA.matches("...[JP]")) rate += Math.abs(a.getTactics()) / 50 * effect;
			if (regexB.matches("[EI]...")) rate += Math.abs(b.getMind()) / 50 * effect;
			if (regexB.matches(".[NS]..")) rate += Math.abs(b.getEnergy()) / 50 * effect;
			if (regexB.matches("..[TF].")) rate += Math.abs(b.getNature()) / 50 * effect;
			if (regexB.matches("...[JP]")) rate += Math.abs(b.getTactics()) / 50 * effect;
		}
		else { //b.toString().matches(regexA))
			if (regexA.matches("[EI]...")) rate += Math.abs(b.getMind()) / 50 * effect;
			if (regexA.matches(".[NS]..")) rate += Math.abs(b.getEnergy()) / 50 * effect;
			if (regexA.matches("..[TF].")) rate += Math.abs(b.getNature()) / 50 * effect;
			if (regexA.matches("...[JP]")) rate += Math.abs(b.getTactics()) / 50 * effect;
			if (regexB.matches("[EI]...")) rate += Math.abs(a.getMind()) / 50 * effect;
			if (regexB.matches(".[NS]..")) rate += Math.abs(a.getEnergy()) / 50 * effect;
			if (regexB.matches("..[TF].")) rate += Math.abs(a.getNature()) / 50 * effect;
			if (regexB.matches("...[JP]")) rate += Math.abs(a.getTactics()) / 50 * effect;
		}
//		System.out.println("\t\t\t" + rate);
		return rate;
	}
	
	public String toString() {
		return "\t" + regexA + " with " + regexB + " has an effect of " + effect;
	}
}
