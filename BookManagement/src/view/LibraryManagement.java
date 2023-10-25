package view;

import controller.Library;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author 84823
 */
public class LibraryManagement extends Menu{
    
    Library library = new Library();
    Scanner sc = new Scanner(System.in);

    public LibraryManagement(String title, String[] s) {
        super(title, s);

    }
    
    
    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                library.getAllBooks();
                break;
            case 2: 
                String menu[] = {"Find by BooID", "Find by Title", 
                    "Find by Author", "Find by Year of publishing"};
                Menu searchMenu = new Menu("Book Searching", menu) {
            @Override
            public void execute(int n) {
                String finds = sc.nextLine();
                switch (n) {
                    case 1:
                        library.searchBook(p -> p.getId().equalsIgnoreCase(finds));
                        break;
                    case 2: 
                        library.searchBook(p -> p.getTitle().contains(finds));
                        break;
                    case 3:
                        library.searchBook(p -> p.getAuthor().equalsIgnoreCase(finds));
                        break;
                    case 4:
                        library.searchBook(p -> p.getYear().equalsIgnoreCase(finds));
                        break;
                    default:
                        return;
                }
            }
        };
            searchMenu.run();
            break;
            case 3: 
                library.addBook();
                break;
            default:
                System.exit(0);
        }
    }
    
}
