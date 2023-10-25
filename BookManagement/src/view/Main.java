package view;

/**
 *
 * @author 84823
 */
public class Main {
    public static void main(String[] args) {
        String arr[] = {"List all books", "Search book", "Add new book", "Exit"};
        LibraryManagement lib = new LibraryManagement("Library Management", arr);
        lib.run();
    }
}
