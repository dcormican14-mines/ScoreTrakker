import java.util.*;

public class Student implements Comparable<Student>{
	private String name;
	private int score;
	
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	public int getScore() {
		return score;
	}

	@Override
	public int compareTo(Student o) {
		return ((Integer)this.score).compareTo((Integer)o.getScore());
	}
	
	@Override
	public String toString() {
		return name + " " + score;
	}
}
