package controller;

import model.Lecturers;
import untils.Inputter;
import untils.Validation;
import view.LecturersView;
import view.Menu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LecturersController extends Menu {
    ArrayList<Lecturers> lecturersList;
    Inputter in = new Inputter();
    Validation val = new Validation();
    Scanner sc = new Scanner(System.in);

    public LecturersController() {
        super("Student Management",
                new ArrayList<>(
                        List.of("Add a new lecturers",
                                "Delete a lecturers by email",
                                "Display all",
                                "Load from file",
                                "Save to file",
                                "Login app",
                                "Change password",
                                "Exit")));
        lecturersList = new ArrayList<>();
    }

    public ArrayList<Lecturers> getLecturersList() {
        return lecturersList;
    }

    public void setLecturersList(ArrayList<Lecturers> lecturersList) {
        this.lecturersList = lecturersList;
    }

    public void addLecturers() {
        String email = in.getStringFromInput("email");
        String passWord = in.getStringFromInput("pass word");
        String fullName = in.getStringFromInput("full name");
        String address = in.getStringFromInput("address");
        String subject = in.getStringFromInput("subject");

        Lecturers lecturers = new Lecturers(email, passWord, fullName, address, subject);
        lecturersList.add(lecturers);
    }

    public void deleteLecturers() {
        String email = in.getStringFromInput(" to delete");

        for (Lecturers lecturers : lecturersList) {
            if (lecturers.getEmail().equals(email)) {
                lecturersList.remove(lecturers);
                System.out.println("Delete successfully !");
                return;
            }
        }
        System.out.println("Email not exist");
    }

    public void readFile() {
        try {
            FileReader fr = new FileReader("lecturers_input.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = null;

            while ((line = br.readLine()) != null) {
                String s[] = line.split("[|]");
                String email = s[0].trim();
                String passWord = s[1].trim();
                String fullName = s[2].trim();
                String address = s[3].trim();
                String subject = s[4].trim();

                Lecturers lecturers = new Lecturers(email,passWord,fullName,address,subject);
                lecturersList.add(lecturers);
            }
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void saveToFile() {
        try {
            FileWriter fw = new FileWriter("lecturers_output.txt");
            for (Lecturers lecturers : lecturersList) {
                fw.write(lecturers.toString());
                fw.write("\n");
            }
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean login(String email, String password) {
        for (Lecturers lecturers : lecturersList) {
            if (lecturers.getEmail().equals(email) && lecturers.getPassWord().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public Lecturers searchEmail(String email) {
        for (Lecturers lecturers : lecturersList) {
            if (lecturers.getEmail().equalsIgnoreCase(email)) {
                return lecturers;
            }
        }
        return null;
    }

    String login = null;
    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                addLecturers();
                System.out.println();
                break;
            case 2:
                deleteLecturers();
                System.out.println();
                break;
            case 3:
                if (lecturersList.isEmpty()) {
                    System.out.println("Lecturers list is empty");
                } else
                    LecturersView.displayLecturers(lecturersList);
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
                if (!getLecturersList().isEmpty()) {
                    String email = in.getStringFromInput("email to login");
                    String password = in.getStringFromInput("password to login");
                    if (login(email, password)) {
                        System.out.println("Login successfully!");
                        login = email;
                    } else
                        System.out.println("Login failed!");
                } else
                    System.out.println("Lecturer list is empty");
                System.out.println();
                break;
            case 7:
                if (login != null) {
                    String oldPass = in.getStringFromInput("old password to change");
                    String newPass = in.getStringFromInput("new password to change");
                    Lecturers change = searchEmail(login);
                    change.changePassWord(oldPass, newPass);
                } else
                    System.out.println("Please login first to change password");
                System.out.println();
                break;
            case 8:
                return;
            default:
                System.exit(0);
        }
    }
}
