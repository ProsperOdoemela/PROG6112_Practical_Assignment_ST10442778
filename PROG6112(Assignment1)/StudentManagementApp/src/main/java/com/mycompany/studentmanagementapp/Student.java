/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentmanagementapp;

/**
 *
 * @author prosp
 */

// Student class
class Student {
    private String studentId;
    private String name;
    private int age;
    private String email;
    private String course;

    public Student(String studentId, String name, int age, String email, String course) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.email = email;
        this.course = course;
    }

    // Getters
    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getCourse() {
        return course;
    }

    // Method to display student details
    public void displayStudent() {
        System.out.println("---------------------------------");
        System.out.println("STUDENT ID: " + studentId);
        System.out.println("STUDENT NAME: " + name);
        System.out.println("STUDENT AGE: " + age);
        System.out.println("STUDENT EMAIL: " + email);
        System.out.println("STUDENT COURSE: " + course);
        System.out.println("---------------------------------");
    }
}
