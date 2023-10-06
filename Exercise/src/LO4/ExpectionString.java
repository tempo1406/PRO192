package LO4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExpectionString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập một số: ");

        try {
            int number;
            number = sc.nextInt();
            System.out.println("Số bạn đã nhập là: " + number);
        }

        catch (InputMismatchException ime) {
            System.err.println("Lỗi: Bạn đã nhập một chuỗi không phải số nguyên.");
        }
    }
}








