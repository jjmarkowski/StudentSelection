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
			randomStudent(students);

		} else if (input.equals("Group Students") || input.equals("2")) {
			System.out.println("Group by Size of Groups(1) or Group by Number of Groups(2)");
			input = reader.nextLine();

			if (input.equals("Group by Size of Groups") || input.equals("1")) {
				System.out.println("Group Size?");
				int input2 = reader.nextInt();
				groupStudentsBySize(students, input2);
			} else if (input.equals("Group by Number of Groups") || input.equals("2")) {
				System.out.println("Number of Groups?");
				int input2 = reader.nextInt();
				groupStudentsByNumber(students, input2);
			}	
		}
	}

	public static void randomStudent(String[] students) {
		Random random = new Random();
		int n = random.nextInt(students.length);
		System.out.println(students[n]);
	}

	public static void groupStudentsBySize(String[] students, int groupSize) {
		students = mixStudents(students);

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

	public static void groupStudentsByNumber(String[] students, int groupAmount) {
		students = mixStudents(students);

		int count = 0;
		for (int i=1; i<=groupAmount; i++) {
			System.out.print("Group " + i +": ");
			for (int j=0; j<students.length/groupAmount; j++) {
				if (count<students.length) {
					System.out.print(students[count] + "  ");
					count++;
				}
			}
			if (i==groupAmount && count==students.length-1) {
				System.out.print(students[count]);	
			}
			System.out.println();
			System.out.println();
		}
	}

	public static String[] mixStudents(String[] students) {
		Random random = new Random();
		for (int i=0; i<students.length; i++) {
			int n = random.nextInt(31-i) + i;
			String extraStudent = students[i];
			students[i] = students[n];
			students[n] = extraStudent;
		}
		return students;
	}

}