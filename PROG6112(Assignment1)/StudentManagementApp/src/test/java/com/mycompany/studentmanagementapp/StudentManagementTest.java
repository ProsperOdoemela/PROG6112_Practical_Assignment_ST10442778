/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.studentmanagementapp;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author prosp
 */



public class StudentTest {
    
    private StudentManagementApp studentManagement;

    @BeforeEach
    public void setUp() {
        studentManagement = new StudentManagementApp();
    }

    // Test for saving a student
    @Test
    public void testSaveStudent(String studentManagement) {
        Student student = new Student("10111", "J.Bloggs", 19, "jbloggs@ymail.com", "disd");
        studentManagement.saveStudent(student);
        assertNotNull(studentManagement.searchStudent("10111"));
    }

    // Test for searching a student
    @Test
    public void testSearchStudent(String  studentManagement) {
        Student student = new Student("10112", "J.Doe", 21, "jdoe@ymail.com", "disd");
        studentManagement.saveStudent(student);
        Student foundStudent = studentManagement.searchStudent("10112");
        assertEquals("J.Doe", foundStudent.getName());
    }

    // Test for searching a student (not found)
    @Test
    public void testSearchStudent_StudentNotFound(String  studentManagement) {
        Student foundStudent = studentManagement.searchStudent("99999");
        assertNull(foundStudent, "Student should not be found.");
    }

    // Test for deleting a student
    @Test
    public void testDeleteStudent(String  studentManagement) {
        Student student = new Student("10113", "P.Parker", 20, "spidey@ymail.com", "disn");
        studentManagement.saveStudent(student);
        boolean isDeleted = studentManagement.deleteStudent("10113");
        assertTrue(isDeleted, "Student should be deleted.");
    }

    // Test for deleting a student (not found)
    @Test
    public void testDeleteStudent_StudentNotFound(String  studentManagement) {
        boolean isDeleted = studentManagement.deleteStudent("99999");
        assertFalse(isDeleted, "Student should not be deleted because they don't exist.");
    }

    // Test for valid student age
    @Test
    public void testStudentAge_StudentAgeValid() {
        Student student = new Student("10111", "J.Bloggs", 19, "jbloggs@ymail.com", "disd");
        assertTrue(student.getAge() >= 16, "Student age should be valid.");
    }

    // Test for invalid student age
    @Test
    public void testStudentAge_StudentAgeInvalid() {
        Student student = new Student("10111", "J.Bloggs", 15, "jbloggs@ymail.com", "disd");
        assertFalse(student.getAge() >= 16, "Student age should be invalid.");
    }

    // Test for invalid character in student age
    @Test
    public void testStudentAge_InvalidCharacter() {
        assertThrows(NumberFormatException.class, () -> {
            Integer.parseInt("abc");
        }, "Student age should be a number.");
    }
}

