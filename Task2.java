
//Student Grade Calculator.
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n");
        System.out.println("-:Student Grading Program:-");
        System.out.println("**************************");

        // obtained marks in each subject.
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        int[] marks = new int[numSubjects];

        System.out.println("Enter marks for each subject (out of 100):");
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
        }

        // Sum of the marks for each subject.
        int totalMarks = calculateTotalMarks(marks);

        // find Average
        double averagePercentage = calculateAveragePercentage(totalMarks, numSubjects);

        // Grade calculation
        char grade = calculateGrade(averagePercentage);

        // Display total makrs, average percentage and grade.
        displayResults(totalMarks, averagePercentage, grade);

        scanner.close();
    }

    private static int calculateTotalMarks(int[] marks) {
        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }
        return totalMarks;
    }

    private static double calculateAveragePercentage(int totalMarks, int numSubjects) {
        return (double) totalMarks / numSubjects;
    }

    private static char calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }

    private static void displayResults(int totalMarks, double averagePercentage, char grade) {
        System.out.println("\nResult of the Subjects:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);
    }
}