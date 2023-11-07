package view;

import model.Student;

import java.util.ArrayList;

public class StudentView {
    public static void displayStudent(ArrayList<Student> listStudent) {
        if (!listStudent.isEmpty()) {
            System.out.println("List Lecturers");
            System.out.println("-----------------------------");
            for (Student student : listStudent) {
                System.out.println(student.toString());
            }
            System.out.println("-----------------------------");
            System.out.println("Total: " + listStudent.size() + " lecturers.");
        }
    }
}
