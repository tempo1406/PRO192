package view;

import controller.StudentList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author ngoctoan
 */
public class StudentManagement extends Menu{
    
    StudentList studentList = new StudentList();
    Scanner sc = new Scanner(System.in);

    public StudentManagement(String title, String[] s) {
        super(title, s);
    }
    
    
    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                studentList.getAllStudent();
                break;
            case 2: 
                String menu[] = {"Find by id", "Find by first name"
                , "Find by last name", "Find by date of birth", "Find by gender", 
                "Exit"};
                Menu searchMenu = new Menu("Student Searching", menu) {
                    @Override
                    public void execute(int n) {
                        String finds = sc.nextLine();
                        switch (n) {
                            case 1:
                                studentList.searchStudent(p -> p.getId().equalsIgnoreCase(finds));
                                break;
                            case 2:
                                studentList.searchStudent(p -> p.getFirstName().contains(finds));
                                break;
                            case 3: 
                                studentList.searchStudent(p -> p.getLastName().contains(finds));
                                break;
                            case 4:
                                DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                LocalDate dateOfYear = LocalDate.parse(finds, dateFormat);
                                studentList.searchStudent(p -> p.getDateOfBirth().equals(finds));
                            default:
                                return;
                        }
                    }
                };
                searchMenu.run();
                break;
            case 3:
                studentList.addStudent();
                break;
            default:
                System.exit(0);
        }
    }
   
    
}
