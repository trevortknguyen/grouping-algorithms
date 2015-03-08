package engine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class CSVLoader {
	File file;
	
	public CSVLoader(File file) {
		setFile(file);
	}
	
	public void setFile(File file) {
		this.file = file;
	}
	
	public LinkedList<Student> readFile() {
		LinkedList<Student> list = new LinkedList<>();
		Scanner scanner;
		try {
			scanner = new Scanner(file);
			scanner.useDelimiter(",");
			scanner.nextLine();
			while (scanner.hasNextLine()) {
				String firstName = scanner.next();
				String lastName = scanner.next();
				
				String nextLine = scanner.nextLine();
				String[] array = nextLine.split(",");
				
				int mind = Integer.parseInt(array[1]);
				int energy = Integer.parseInt(array[2]);
				int nature = Integer.parseInt(array[3]);
				int tactics = Integer.parseInt(array[4]);
				
				Student s = new Student(firstName, lastName, new Personality(mind, energy, nature, tactics));

				list.add(s);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public LinkedList<Student> readGoogleFile() {
		LinkedList<Student> list = new LinkedList<>();
		Scanner scanner;
		try {
			scanner = new Scanner(file);
			scanner.useDelimiter(",");
			scanner.nextLine();
			while (scanner.hasNextLine()) {
				scanner.next();
				String firstName = scanner.next();
				String lastName = scanner.next();
				
				String nextLine = scanner.nextLine();
				String[] array = nextLine.split(",");
				
				int mind = Integer.parseInt(array[1]);
				int energy = Integer.parseInt(array[2]);
				int nature = Integer.parseInt(array[3]);
				int tactics = Integer.parseInt(array[4]);

				Student s = new Student(firstName, lastName, new Personality(mind, energy, nature, tactics));

				list.add(s);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}
}
