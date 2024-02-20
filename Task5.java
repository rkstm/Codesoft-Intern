//Student Management System

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Student implements Serializable {
    private String name;
    private int rollNumber;
    private String grade;

    // Constructor
    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() { // Getters and setters
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollNumber=" + rollNumber +
                ", grade='" + grade + '\'' +
                '}';
    }
}

class StudentManagementSystem {
    private ArrayList<Student> students;
    private static final String FILE_NAME = "students.dat";

    public StudentManagementSystem() {
        students = readFromFile();
    }

    // Add a student to the system
    public void addStudent(Student student) {
        students.add(student);
        writeToFile();
    }

    // Remove a student from the system
    public void removeStudent(int rollNumber) {
        students.removeIf(student -> student.getRollNumber() == rollNumber);
        writeToFile();
    }

    // Search for a student by roll number
    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    // Display all students
    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    // Write student data to a file
    private void writeToFile() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            outputStream.writeObject(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Read student data from a file

    @SuppressWarnings("unchecked")
    private ArrayList<Student> readFromFile() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (ArrayList<Student>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
}

public class Task5 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            StudentManagementSystem system = new StudentManagementSystem();

            while (true) {
                System.out.println("1. Add Student");
                System.out.println("2. Remove Student");
                System.out.println("3. Search for Student");
                System.out.println("4. Display All Students");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        System.out.print("Enter student name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter roll number: ");
                        int rollNumber = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                        System.out.print("Enter grade: ");
                        String grade = scanner.nextLine();

                        Student newStudent = new Student(name, rollNumber, grade);
                        system.addStudent(newStudent);
                        System.out.println("Student added successfully.");
                        break;

                    case 2:
                        System.out.print("Enter roll number of student to remove: ");
                        int removeRollNumber = scanner.nextInt();
                        system.removeStudent(removeRollNumber);
                        System.out.println("Student removed successfully.");
                        break;

                    case 3:
                        System.out.print("Enter roll number of student to search: ");
                        int searchRollNumber = scanner.nextInt();
                        Student foundStudent = system.searchStudent(searchRollNumber);
                        if (foundStudent != null) {
                            System.out.println("Student found: " + foundStudent);
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;

                    case 4:
                        System.out.println("All Students:");
                        system.displayAllStudents();
                        break;

                    case 5:
                        System.out.println("Exiting the application.");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }
}

// Thank You So Much :)