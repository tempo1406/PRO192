package controller;

import model.Lecturers;
import view.Menu;

import java.util.ArrayList;
import java.util.List;

public class SchoolController extends Menu {
    private StudentController studentController;
    private LecturersController lecturersController;


    public SchoolController() {
        super("School Management System",
                new ArrayList<>(
                        List.of("Student Management",
                                "Lecturers Management",
                                "Exit")));

        studentController = new StudentController();
        lecturersController = new LecturersController();

    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                studentController.run();
                break;
            case 2:
                lecturersController.run();
                break;
            case 3:
                System.err.println("Exited.");
                break;
            default:
                System.err.println("Invalid choice. Please try again.");
        }
    }

    public static void main(String[] args) {
        SchoolController app = new SchoolController();
        app.run();
    }
}
