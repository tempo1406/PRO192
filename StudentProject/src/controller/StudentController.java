package controller;

import model.Student;
import untils.Inputter;
import untils.Validation;
import view.Menu;
import view.StudentView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class StudentController extends Menu {
    ArrayList<Student> studentList;
    Inputter in = new Inputter();
    Validation val = new Validation();
    Scanner sc = new Scanner(System.in);

    public StudentController() {
        super("Student Management",
                new ArrayList<>(
                        List.of("Add a new student",
                                "Delete a student by id",
                                "Display all",
                                "Load from file",
                                "Save to file",
                                "Sort by gpa",
                                "Search student",
                                "Exit")));
        studentList = new ArrayList<>();
    }

    public boolean searchID(String id) {
        if (!studentList.isEmpty()) {
            for (Student student : studentList) {
                if (student.getId().equalsIgnoreCase(id)) {
                    return true;
                }
            }
            return false;
        } else {
            return true;
        }
    }

    public void addStudent() {
        String message = "id";
        String id;
        while (true) {
            id = in.getStringFromInput(message);
            if (!searchID(id)) {
                break;
            } else {
                message = "ID is exist. Enter again";
            }
        }
        String email = in.getStringFromInput("email");
        String fullName = in.getStringFromInput("author name");
        String gender = in.getStringFromInput("gender");
        String phoneNum = in.getStringFromInput("phone number");
        String address = in.getStringFromInput("address");
        String major = in.getStringFromInput("major");
        String gpaStr = in.getStringFromInput("gpa");
        double gpa;
        while (true) {
            if (val.isNumericDouble(gpaStr)) {
                gpa = Double.parseDouble(gpaStr);
                break;
            } else {
                System.out.println("Invalid double number, pls enter again");
                gpaStr = in.getStringFromInput("gpa");
            }
        }

        Student student = new Student(id, email, fullName, gender, phoneNum, address, major, gpa);
        studentList.add(student);
    }

    public void deleteStudent() {
        String id = in.getStringFromInput("id to delete student");

        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                studentList.remove(student);
                System.out.println("Delete successfully !");
                return;
            }
        }
        System.out.println("Id not exist");
    }


    public void readFile() {
        try {
            FileReader fr = new FileReader("students_input.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = null;

            while ((line = br.readLine()) != null) {
                String s[] = line.split("[|]");
                String id = s[0].trim();
                String email = s[1].trim();
                String fullName = s[2].trim();
                String gender = s[3].trim();
                String phoneNum = s[4].trim();
                String address = s[5].trim();
                String major = s[6].trim();
                Double gpa = Double.parseDouble(s[7].trim());

                Student student = new Student(id, email, fullName, gender, phoneNum, address, major, gpa);
                studentList.add(student);
            }
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void saveToFile() {
        try {
            FileWriter fw = new FileWriter("students_output.txt");
            for (Student student : studentList) {
                fw.write(student.toString());
                fw.write("\n");
            }
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sortStudentByGPA() {
        int n = studentList.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (studentList.get(j).getGpa() < studentList.get(minIndex).getGpa()) {
                    minIndex = j;
                }
            }
            Student temp = studentList.get(i);
            studentList.set(i, studentList.get(minIndex));
            studentList.set(minIndex, temp);
        }
    }

    public void printList(ArrayList<Student> sList) {
        for (Student student : sList) {
            System.out.println(student.toString());
        }
    }

    public void searchByCondition(Predicate<Student> p) {
        ArrayList<Student> findDoctors = new ArrayList();
        for (Student student : studentList) {
            if (p.test(student)) {
                findDoctors.add(student);
            }
        }
        printList(findDoctors);
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                addStudent();
                System.out.println();
                break;
            case 2:
                deleteStudent();
                System.out.println();
                break;
            case 3:
                if (studentList.isEmpty()) {
                    System.out.println("Student list is empty");
                } else
                    StudentView.displayStudent(studentList);
                System.out.println();
                break;
            case 4:
                readFile();
                System.out.println("Load from file successfully!");
                System.out.println();
                break;
            case 5:
                saveToFile();
                System.out.println("Save to file successfully!");
                System.out.println();
                break;
            case 6:
                sortStudentByGPA();
                System.out.println("Sort student successfully!");
                System.out.println();
                break;
            case 7:
                Menu searchMenu = new Menu("Search Student",
                        new ArrayList<>(
                                List.of("Search student by ID",
                                        "Search student by Name",
                                        "Search student by Phone Number",
                                        "Exit"))) {
                    @Override
                    public void execute(int choice) {
                        switch (choice) {
                            case 1:
                                String id = in.getStringFromInput("id to search");
                                searchByCondition(p -> p.getId().equalsIgnoreCase(id));
                                System.out.println();
                                break;
                            case 2:
                                String name = in.getStringFromInput("full name to search");
                                searchByCondition(p -> p.getFullName().contains(name));
                                System.out.println();
                                break;
                            case 3:
                                String phoneNum = in.getStringFromInput("phone number to search");
                                searchByCondition(p -> p.getPhoneNumber().equalsIgnoreCase(phoneNum));
                                System.out.println();
                                break;
                            default:
                                return;
                        }
                    }
                };
                searchMenu.run();
                System.out.println();
                break;
            case 8:
                return;
            default:
                System.exit(0);
        }
    }
};
