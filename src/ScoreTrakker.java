import java.util.*;
import java.io.*;

public class ScoreTrakker {
	private ArrayList<Student> students = new ArrayList<>();
	
	public void loadDataFile(String inFile) throws IOException {
		FileReader in = new FileReader(inFile);
		int counter;
		boolean isScore = false;
		String name = "", curr = "";
		
		while ((counter = in.read()) != -1) {
			if (counter != 10) { // ascii value for new line character
				curr += (char)counter;
			} else {
				// there is an error with curr (it includes the new line character for some reason)
				if (isScore) {
					System.out.println(Integer.parseInt(curr));
					students.add(new Student(name, Integer.parseInt(curr)));
				} else {
					name = curr;
				}
				curr = ""; // resets current line.
				isScore = !isScore; // flips the boolean to make sure we get all information for one student
			}
		}
		in.close();
	}
	
	public void printInOrder() {
		Collections.sort(students);
		for (Student curr: students) System.out.println(curr);
	}
	
	private void processFiles() throws IOException{
		this.loadDataFile("Scores.txt");
		this.printInOrder();
	}
	
	public static void main(String[] args) throws IOException{
		ScoreTrakker st = new ScoreTrakker();
		st.processFiles();
	}
}

