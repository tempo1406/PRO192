package LO4;

import java.util.Scanner;

public class Exceptiondiv {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số chia: ");
        int number1 = sc.nextInt();
        System.out.println("Nhập số bị chia: ");
        int number2 = sc.nextInt();
        try {
            int result = number1 / number2;
            System.out.println("Kết quả: " + result);
        } catch (ArithmeticException ae) {
            System.out.println("Không thể chia hết cho 0");
        }
    }
}

