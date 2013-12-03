import java.util.Scanner;
import java.io.*;
import java.util.Random;

public class StudentSelection {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		String[] students = new String[31];

		try {
			Scanner scan = new Scanner(new File("class.csv"));
			String[] students2 = scan.nextLine().split(",");
			students = students2;
		} catch(IOException e) {
			System.out.println("Could not load file");
			System.exit(1);
		}

		System.out.println("Pick Random Student(1) or Group Students(2)");
		String input = reader.nextLine();

		if (input.equals("Pick Random Student") || input.equals("1")) {
			Random random = new Random();
			int n = random.nextInt(students.length);
			System.out.println(students[n]);
		} else if (input.equals("Group Students") || input.equals("2")) {
			System.out.println("Group Size?");
			int groupSize = reader.nextInt();
			group(students, groupSize);
		}
	}

	public static void group(String[] students, int groupSize) {
		Random random = new Random();
		for (int i=0; i<students.length; i++) {
			int n = random.nextInt(31-i) + i;

			String extraStudent = students[i];
			students[i] = students[n];
			students[n] = extraStudent;
		}

		int count = 0;

		for (int i=1; i<=students.length/groupSize+1; i++) {
			System.out.print("Group " + i +": ");
			for (int j=0; j<groupSize; j++) {
				if (count<students.length) {
					System.out.print(students[count] + "  ");
					count++;
				}
			}
			System.out.println();
			System.out.println();
		}
		
	}	
}