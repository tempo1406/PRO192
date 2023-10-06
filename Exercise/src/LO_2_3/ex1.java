package LO_2_3;

import java.util.Scanner;

public class ex1 {
    public static void main(String[] args) {
        double a, b;
        String name, ten;
        double chuyenCan, giuaKy, cuoiKy;
        String[] list = new String[4];
        int count;
        count = 0;

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap a: ");
        a = sc.nextDouble();
        System.out.print("Nhap b: ");
        b = sc.nextDouble();

        sc.nextLine();
        System.out.print("Nhap ten: ");
        name = sc.nextLine();


        System.out.print("Nhap diem chuyen can: ");
        chuyenCan = sc.nextDouble();
        System.out.print("Nhao diem giua ki: ");
        giuaKy = sc.nextDouble();
        System.out.print("Nhap diem cuoi ki: ");
        cuoiKy = sc.nextDouble();

        System.out.println("a + b: " + (a + b));
        System.out.println("a x b: " + (a * b));
        System.out.println("a / b: " + (a / b));

        System.out.println("In ra ho va ten: " + name);

        System.out.println("Diem hoc phan: " + ((chuyenCan * 0.1) + (giuaKy * 0.2) + (cuoiKy * 0.7)));

        sc.nextLine();
        list[0] = "Nguyen Ngoc Toan";
        list[1] = "Nguyen Ngoc Minh";
        list[2] = "Phan Thi Tu";
        list[3] = "Nguyen Xuan Thang";

        System.out.print("Nhap ten de kiem tra voi list: ");
        ten = sc.nextLine();
        for (int i = 0; i <= 3; i++) {
            if(ten.equals(list[i])) {
                count ++;
            }
        }
        if (count == 1) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }

    }

}
