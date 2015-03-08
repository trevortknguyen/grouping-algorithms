package engine;

import matchmaker.PersonalityRule;

public final class Personality implements Matchable {
	private int mind;
	private int energy;
	private int nature;
	private int tactics;
	

	public Personality(int mind, int energy, int nature, int tactics) {
		this.mind = mind;
		this.energy = energy;
		this.nature = nature;
		this.tactics = tactics;
	}
	
	@SuppressWarnings("unused")
	@Deprecated
 	private boolean contains(CharSequence s) {
		return this.toString().contains(s);
	}
	
	public int getMind() {
		return mind;
	}

	public int getEnergy() {
		return energy;
	}

	public int getNature() {
		return nature;
	}

	public int getTactics() {
		return tactics;
	}



	public boolean equals(Object o) {
		return this.toString().equals(o.toString());
	}
	
	public String toString() {
		String personality = "";
		
		if (mind > 0) personality += 'I';
		else personality += 'E';
		
		if (energy < 0) personality += 'N';
		else personality += 'S';
		
		if (nature > 0) personality += 'F';
		else personality += 'T';
		
		if (tactics > 0) personality += 'P';
		else personality += 'J';
		
		return personality;
	}
	
	@Override
	public int matchWith(Object o) {
		Personality p = (Personality) o;
		int rate = 0;
		
		for (int i = 0; i < 4; i++) {
			if (this.toString().charAt(i) == p.toString().charAt(i)) rate += 1;
		}
		
		for (PersonalityRule rule : PersonalityRule.ruleList) {
//				System.out.println(rule);
				rate += rule.getCompatibility(this, p);
		}
		
		return rate;
	}
}