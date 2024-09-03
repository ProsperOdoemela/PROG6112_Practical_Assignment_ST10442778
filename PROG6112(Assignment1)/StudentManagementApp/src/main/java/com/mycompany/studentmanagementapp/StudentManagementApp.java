/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
//W3schools.com (no date) W3Schools Online Web Tutorials. Available at: https://www.w3schools.com/ (Accessed: 03 September 2024). 
//Learn to code - for free (no date) Codecademy. Available at: https://www.codecademy.com/ (Accessed: 03 September 2024). 
//Build new skills. advance your career. (no date) edX. Available at: https://www.edx.org/ (Accessed: 03 September 2024). 
//FreeCodeCamp.org (no date) freecodecamp.org. Available at: https://www.freecodecamp.org/ (Accessed: 03 September 2024). 

package com.mycompany.studentmanagementapp;

/**
 *
 * @author prosp
 */
import java.util.ArrayList;
import java.util.Scanner;


public class StudentManagementApp {
    public static ArrayList<Student> students = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("STUDENT MANAGEMENT APPLICATION");
            System.out.println("*******************************");
            System.out.println("Enter (1) to launch menu or any other key to exit");

            String input = scanner.nextLine();
            if (!input.equals("1")) {
                System.out.println("Exiting the application.");
                break;
            }

            displayMenu();
        }
    }

    public static void displayMenu() {
        System.out.println("Please select one of the following menu items:");
        System.out.println("(1) Capture a new student.");
        System.out.println("(2) Search for a student.");
        System.out.println("(3) Delete a student.");
        System.out.println("(4) Print student report.");
        System.out.println("(5) Exit Application.");

        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                captureStudent();
                break;
            case "2":
                searchStudent();
                break;
            case "3":
                deleteStudent();
                break;
            case "4":
                printStudentReport();
                break;
            case "5":
                System.out.println("Exiting the application.");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice! Please select a valid option.");
        }
    }

    public static void captureStudent() {
        System.out.println("CAPTURE A NEW STUDENT");
        System.out.print("Enter the student ID: ");
        String studentId = scanner.nextLine();

        System.out.print("Enter the student name: ");
        String name = scanner.nextLine();

        int age = 0;
        while (true) {
            System.out.print("Enter the student age: ");
            try {
                age = Integer.parseInt(scanner.nextLine());
                if (age >= 16) break;
                else System.out.println("Student age must be 16 or older.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number for age.");
            }
        }

        System.out.print("Enter the student email: ");
        String email = scanner.nextLine();

        System.out.print("Enter the student course: ");
        String course = scanner.nextLine();

        Student student = new Student(studentId, name, age, email, course);
        students.add(student);
        System.out.println("Student captured successfully!");
    }

    public static void searchStudent() {
        System.out.print("Enter the student ID to search: ");
        String studentId = scanner.nextLine();

        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                student.displayStudent();
                return;
            }
        }
        System.out.println("Student with Student ID: " + studentId + " was not found!");
    }

    public static void deleteStudent() {
        System.out.print("Enter the student ID to delete: ");
        String studentId = scanner.nextLine();

        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                System.out.print("Are you sure you want to delete this student? (y/n): ");
                String confirmation = scanner.nextLine();
                if (confirmation.equalsIgnoreCase("y")) {
                    students.remove(student);
                    System.out.println("Student with Student ID: " + studentId + " WAS deleted!");
                }
                return;
            }
        }
        System.out.println("Student with Student ID: " + studentId + " was not found!");
    }

    public static void printStudentReport() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (int i = 0; i < students.size(); i++) {
            System.out.println("STUDENT " + (i + 1));
            students.get(i).displayStudent();
        }
    }
}



