package engine;

import java.io.File;
import java.util.LinkedList;

import matchmaker.PersonalityRule;



public class GroupingAlgorithms {
	static LinkedList<Student> list;
	
	public static void initialize() {
		CSVLoader dataLoader;
		RuleLoader ruleLoader;
		
		
		PersonalityRule.ruleList = new LinkedList<>();
		dataLoader = new CSVLoader(new File("C:\\Users\\Thai Nguyen\\Desktop\\Form1.csv"));
		ruleLoader = new RuleLoader(new File("C:\\Users\\Thai Nguyen\\Desktop\\Rule1.csv"));
		
		list = dataLoader.readGoogleFile();
		ruleLoader.readFile();
	}
	
	public static void main(String[] args) {
		initialize();
		
		for (Student s : list) {
			System.out.println(s);
		}
		System.out.println();
		
		for (int i = 0; i < list.size(); i++) {
			Student a = list.get(i);
			for (int j = i + 1; j < list.size(); j++) {
				Student b = list.get(j);
				System.out.print(String.format("%+3d", a.matchWith(b)));
				System.out.println("\t" + a + " / " + b);
			}
		}
	}
}
