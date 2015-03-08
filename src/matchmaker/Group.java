package matchmaker;

import engine.Student;


public class Group {
	private int capacity;
	private Student[] students;
	
	public Group(int capacity) {
		this.capacity = capacity;
		students = new Student[this.capacity];
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public boolean setCapacity(int capacity) {
		if (capacity < this.capacity)
			return false;
		else {
			Student[] temp = students;
			students = new Student[capacity];
			
			for (int i = 0; i < temp.length; i++) {
				students[i] = temp[i];
			}
			
			this.capacity = students.length;
			return true;
		}
	}
	
	public boolean addStudent(Student student) {
		for (int i = 0; i < students.length; i ++) {
			if (students[i] == null) {
				students[i] = student;
				return true;
			}
		}
		return false;
	}

}
