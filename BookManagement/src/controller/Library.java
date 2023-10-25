package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import model.Book;

/**
 *
 * @author 84823
 */
public class Library {
    private ArrayList<Book> listBook;
    Scanner sc = new Scanner(System.in);
    public Library() {
        listBook = new ArrayList<>();
//        try {
//            readFile();
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found: " + e.getMessage());
//        }
    }
    
//    public void readFile() throws FileNotFoundException {
//        String filePath = "lib.txt";
//        File file = new File(filePath);
//        FileReader fr = new FileReader(file);
//
//        try (BufferedReader br = new BufferedReader(fr)){
//            String line = br.readLine();
//            String[] s = line.split("-");
//            String id = s[0];
//            String title = s[1];
//            String author = s[2];
//            String year = s[3];
//
//            Book newBook = new Book(id,title,author,year);
//            listBook.add(newBook);
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }

    public void readFile() {
        try {
            FileReader fr = new FileReader("lib.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = null;

            while ((line = br.readLine()) != null) {
                String arr[] = line.split("-");
                if (arr.length == 4) {
                    String bookId = arr[0];
                    String bookTitle = arr[1];
                    String bookAuthor = arr[2];
                    String bookYear = arr[3];

                    Book book = new Book(bookId, bookTitle, bookAuthor, bookYear);
                    listBook.add(book);
                }
            }
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    
    public void printList(ArrayList<Book> bList) {
        for (Book book : bList) {
            System.out.println(book.toString());
        }
    }
    
    public void searchBook(Predicate<Book> p) {
        ArrayList<Book> findBooks = new ArrayList<>();
        for (Book book : listBook) {
            if(p.test(book)) {
                findBooks.add(book);
            }
        }
        printList(findBooks);
    }
    
    public void addBook() {
        System.out.println("Enter book id: ");
        String id = sc.nextLine();
        System.out.println("Enter book title: ");
        String title = sc.nextLine();
        System.out.println("Enter book author: ");
        String author = sc.nextLine();
        System.out.println("Enter book year publish: ");
        String year = sc.nextLine();
        
        Book book = new Book(id,title,author,year);
        listBook.add(book);
    }
 
    public void getAllBooks() {
        int count =0;
        System.out.println("List of books");
        System.out.println("------------------------------");
        if (listBook.isEmpty()) {
            readFile();
        }
        printList(listBook);
        System.out.println("---------------------------");
        for (Book book : listBook) {
            count ++;
        }
        System.out.println("Total: " + count + " books.");
    }

//        public void writeFile() {
//        try {
//            FileWriter fw = new FileWriter("lib.txt");
//            String line = "";
//            for (Book book : listBook) {
//                line += book.getId() + "," + book.getTitle() + "," + book.getAuthor() + "," + book.getYear() + "\n";
//            }
//            fw.write(line);
//            fw.close();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
}

// Đọc theo kiểu Trương Gia Bình
//public void readFile() throws FileNotFoundException {
//    String filePath = "lib.txt";
//    File file = new File(filePath);
//
//    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
//        String line;
//        while ((line = br.readLine()) != null) {
//            String[] s = line.split("-");
//            if (s.length == 4) {
//                String id = s[0];
//                String title = s[1];
//                String author = s[2];
//                String year = s[3];
//
//                Book newBook = new Book(id, title, author, year);
//                listBook.add(newBook);
//            } else {
//                System.err.println("Invalid data format: " + line);
//            }
//        }
//    } catch (Exception e) {
//        System.out.println(e);
//    }
//}