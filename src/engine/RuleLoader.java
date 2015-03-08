package engine;

import java.io.File;

import matchmaker.PersonalityRule;

public class RuleLoader {
	File file;
	
	public RuleLoader(File file) {
		setFile(file);
	}
	
	public void setFile(File file) {
		this.file = file;
	}
	
	public void generateRulesFromProgram() {
		// Source: http://www.typefinder.com/story/compatibility-and-your-myers-briggs-personality-type
		new PersonalityRule(".S.J", ".S.J", 29);
		new PersonalityRule(".NF.", ".NF.", 23);
		new PersonalityRule(".NFP", ".STJ", -8);
		new PersonalityRule(".SFJ", ".NFP", 36);
		new PersonalityRule(".SFJ", ".NFJ", 17);
		new PersonalityRule(".STP", ".STP", -17);
		new PersonalityRule(".NT.", ".NT.", 9);
		
		//Source: 
//		new PersonalityRule("INTP", "....", -31);
//		new PersonalityRule("INTP", "INTP", 31);
		
		//Source:
		new PersonalityRule("INTJ", ".N..", 20);
		new PersonalityRule("INTJ", ".S..", 15);
		new PersonalityRule("INTP", ".NT.", 10);
		new PersonalityRule("INTP", ".N.", 10);
	}
}
