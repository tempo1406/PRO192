package view;

/**
 *
 * @author ngoctoan
 */
public class Main {
    public static void main(String[] args) {
        String arr[] = {"List all Students", "Search Students", 
        "Add new Students", "Exit"};
        StudentManagement std = new StudentManagement("Student Management", arr);
        std.run();
    }
}
