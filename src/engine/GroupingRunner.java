package engine;

import java.io.File;
import java.util.LinkedList;

import matchmaker.PersonalityRule;

public class GroupingRunner {
	public static void main(String[] args) {
		PersonalityRule.ruleList = new LinkedList<>();
		CSVLoader dataLoader;
		RuleLoader ruleLoader;
		LinkedList<Student> list;
		
		dataLoader = new CSVLoader(new File("C:\\Users\\Thai Nguyen\\Desktop\\Form1.csv"));
		ruleLoader = new RuleLoader(new File("C:\\Users\\Thai Nguyen\\Desktop\\Rule1.csv"));
		
		list = dataLoader.readGoogleFile();
		ruleLoader.generateRulesFromProgram(); //WTF are you doing here?
		ruleLoader.readFile();
		
		for (Student s : list) {
			System.out.println(s);
		}
		System.out.println();
		
		for (int i = 0; i < list.size(); i++) {
			Student a = list.get(i);
			Student b;
			for (int j = i + 1; j < list.size(); j++) {
				if (!a.equals((b = list.get(j)))) {
					System.out.print(String.format("%+3d", a.matchWith(b)));
					System.out.println("\t" + a + " / " + b);
				}
			}
		}
	}
}
