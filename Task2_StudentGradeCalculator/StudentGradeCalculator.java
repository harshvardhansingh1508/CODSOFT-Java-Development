package Task2_StudentGradeCalculator;
import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int subjects = sc.nextInt();

        int totalMarks = 0;

        // Input marks for each subject
        for (int i = 1; i <= subjects; i++) {
            int marks;

            do {
                System.out.print("Enter marks for Subject " + i + " (0-100): ");
                marks = sc.nextInt();

                if (marks < 0 || marks > 100) {
                    System.out.println("Invalid marks! Please enter marks between 0 and 100.");
                }

            } while (marks < 0 || marks > 100);

            totalMarks += marks;
        }

        // Calculate average percentage
        double averagePercentage = (double) totalMarks / subjects;

        // Calculate grade
        char grade;

        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else if (averagePercentage >= 50) {
            grade = 'E';
        } else {
            grade = 'F';
        }

        // Display results
        System.out.println("\n===== Result =====");
        System.out.println("Total Marks: " + totalMarks + " / " + (subjects * 100));
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);

        sc.close();
    }
}