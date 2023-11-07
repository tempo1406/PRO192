package view;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Menu {

    protected String title;
    protected ArrayList<String> list = new ArrayList<>();

    public Menu() {
    }

    public Menu(String title, String[] s) {
        this.title = title;
        for (String item : s) {
            list.add(item);
        }
    }

    public void display() {
        System.out.println(title);
        System.out.println("-------------------------------------");
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
        System.out.println("-------------------------------------");
    }

    public int getChoice() {
       Scanner sc = new Scanner(System.in);
        System.out.println("Enter selection.. ");
        int choice = sc.nextInt();
        return choice;
    }

    public abstract void execute(int n);

    public void run() {
        int choice;
        do {
            display();
            choice = getChoice();
            execute(choice);
        } while (choice > 0 && choice < list.size());
    }

}
