package engine;

public class Student implements Matchable, Comparable<Student> {
	private int averageGrade;
	private final String firstName;
	private final String lastName;
	private Personality personality;
	
	public Student (String firstName, String lastName, Personality personality) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.personality = personality;
	}
	
	public void setPersonality(Personality personality) {
		this.personality = personality;
	}
	
	public Personality getPersonality() {
		return personality;
	}
	
	public int compareTo(Student s) {
		return s.averageGrade - this.averageGrade;
	}
	
	public int matchWith(Object o) {
		Student s = (Student) o;
		int rate = 0;
		rate += this.personality.matchWith(s.personality);
		
		
		//add more calculations here
		return rate;
	}
	
	public String toString() {
		return lastName + ", " + firstName + " - " + personality;
	}
}
