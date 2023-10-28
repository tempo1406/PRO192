package view;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ngoctoan
 */
public abstract class Menu {
     protected String title;
    protected ArrayList<String> list = new ArrayList();
    
    public Menu(){}
    public Menu(String title, String[] s) {
        this.title = title;
        for (String item : s) {
            list.add(item);
        }
    }

    public void display() {
        System.out.println(title);
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }

    public int getChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter selection: ");
        int choice = scanner.nextInt();
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
