package engine;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import matchmaker.PersonalityRule;

public class RuleLoader {
	File file;
	
	public RuleLoader(File file) {
		setFile(file);
	}
	
	public void setFile(File file) {
		this.file = file;
	}
	
	public void readFile() {
		Scanner scanner;
		try {
			scanner = new Scanner(file);
			scanner.nextLine();
			
			while (scanner.hasNextLine()) {
				String s = scanner.nextLine();
				String[] split = s.split(",");
				
				char[] regexA = {'.', '.', '.', '.'};
				for (int i = 0; i < regexA.length; i++) {
					if (split[0].matches(".*[EI].*")) regexA[0] = (split[0].contains("E") ? 'E' : 'I');
					if (split[0].matches(".*[NS].*")) regexA[1] = (split[0].contains("N") ? 'N' : 'S');
					if (split[0].matches(".*[TF].*")) regexA[2] = (split[0].contains("T") ? 'T' : 'F');
					if (split[0].matches(".*[JP].*")) regexA[3] = (split[0].contains("J") ? 'J' : 'P');
				}
				
				char[] regexB = {'.', '.', '.', '.'};
				for (int i = 0; i < regexB.length; i++) {
					if (split[1].matches(".*[EI].*")) regexB[0] = (split[1].contains("E") ? 'E' : 'I');
					if (split[1].matches(".*[NS].*")) regexB[1] = (split[1].contains("N") ? 'N' : 'S');
					if (split[1].matches(".*[TF].*")) regexB[2] = (split[1].contains("T") ? 'T' : 'F');
					if (split[1].matches(".*[JP].*")) regexB[3] = (split[1].contains("J") ? 'J' : 'P');
				}
				
				PersonalityRule rule = new PersonalityRule(new String(regexA), new String(regexB), Integer.parseInt(split[2]));
//				System.out.println(rule);
			}
			
			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
		
//		Source:
		new PersonalityRule("INTJ", ".N..", 20);
		new PersonalityRule("INTJ", ".S..", 15);
		new PersonalityRule("INTP", ".NT.", 10);
		new PersonalityRule("INTP", ".N.", 10);
	}
}
