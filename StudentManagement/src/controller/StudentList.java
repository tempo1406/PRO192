package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Predicate;
import modul.Student;

/**
 *
 * @author ngoctoan
 */
public class StudentList {

    private ArrayList<Student> listStudent = new ArrayList();
    Scanner sc = new Scanner(System.in);

    public StudentList() {
    }

    public void readFile() {
        try {
            FileReader fr = new FileReader("src/student.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = null;

            while ((line = br.readLine()) != null) {
                String arr[] = line.split(", ");
                String id = arr[0];
                String firstName = arr[1];
                String lastName = arr[2];
                DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate dateOfBirth = LocalDate.parse(arr[3], dateFormat);
                String gender = arr[4];

                Student student = new Student(id, firstName, lastName, dateOfBirth, gender);
                listStudent.add(student);

            }
            Collections.sort(listStudent);
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void printList(ArrayList<Student> sList) {
        for (Student student : sList) {
            System.out.println(student.toString());
        }
    }

    public void searchStudent(Predicate<Student> p) {
        ArrayList<Student> findStudents = new ArrayList<>();
        for (Student student : listStudent) {
            if (p.test(student)) {
                findStudents.add(student);
            }
        }
        printList(findStudents);
    }

    public void addStudent() {
        System.out.println("Input id: ");
        String id = sc.nextLine();
        System.out.println("Input first name: ");
        String fname = sc.nextLine();
        System.out.println("Input last name: ");
        String lname = sc.nextLine();
        System.out.println("Input date of birth: ");
        String dateInput = sc.nextLine();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateOfBirth = LocalDate.parse(dateInput, dateFormat);
        System.out.println("Input gender: ");
        String gender = sc.nextLine();

        Student student = new Student(id, fname, lname, dateOfBirth, gender);
        listStudent.add(student);
    }


    public void getAllStudent() {
        System.out.println("List of Students");
        System.out.println("--------------------------------");
        if (listStudent.isEmpty()) {
            readFile();
        }
        printList(listStudent);
        System.out.println("--------------------------------");
    }
}
