package view;

import model.Lecturers;

import java.util.ArrayList;

public class LecturersView {
    public static void displayLecturers(ArrayList<Lecturers> listLecturers) {
        if (!listLecturers.isEmpty()) {
            System.out.println("List Lecturers");
            System.out.println("-----------------------------");
            for (Lecturers lecturers : listLecturers) {
                System.out.println(lecturers.toString());
            }
            System.out.println("-----------------------------");
            System.out.println("Total: " + listLecturers.size() + " lecturers.");
        }
    }
}
