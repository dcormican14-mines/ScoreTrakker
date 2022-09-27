import java.util.*;
import java.io.*;

public class ScoreTrakker {
	private ArrayList<Student> students = new ArrayList<>();
	
	public void loadDataFile(String inFile) throws IOException {
		try {
			BufferedReader in = new BufferedReader(new FileReader(inFile));
			String str;
			boolean isScore = false;
			String name = "";
			
			while ((str = in.readLine()) != null) {
				if (isScore) {
					try {
						students.add(new Student(name, Integer.parseInt(str)));
					} catch (Exception e) {
						System.out.println("Incorrect format for " + name + "not a valid score: " + str);
					}
				} else {
					name = str;
				}
				isScore = !isScore; // flips the boolean to make sure we get all information for one student
			}
			in.close();
		} catch (Exception e){
			System.out.println("Something went wrong while trying to read the file. \n" + e.toString());
		}
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

