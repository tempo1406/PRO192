package LO8;

import java.util.Scanner;

public class QuanLy extends ItemList{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. Quan li sinh vien");
            System.out.println("2. Quan li giang vien");
            System.out.println("3. Thoat");
            System.out.print("Chon loai quan li: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    quanLiSinhVien(sc);
                    break;
                case 2:
                    quanLiGiangVien(sc);
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Vui long lua chon lai");
            }
        }
    }

    private static void quanLiSinhVien(Scanner sc) {
        while (true) {
            System.out.println("Quan li sinh vien:" );
            System.out.println("1. Them sinh vien");
            System.out.println("2. Sua thong tin sdt");
            System.out.println("3. Tim kiem sinh vien theo email");
            System.out.println("4. Tim kiem sinh vien theo chuyen nganh");
            System.out.println("5. Xoa sinh vien");
            System.out.println("6. Hien thi toan bo sinh vien");
            System.out.println("7. Quay lai");
            System.out.print("Lua chon option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    themSinhVien(sc);
                    break;
                case 2:
                    suaSdtSinhVien(sc);
                    break;
                case 3:
                    timSinhVien(sc);
                    break;
                case 4:
                    timSinhVienTheoCN(sc);
                    break;
                case 5:
                    xoaSinhVien(sc);
                    break;
                case 6:
                    hienThiSinhVien();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Vui long chon lai");
            }
        }
    }
    private static void quanLiGiangVien(Scanner sc) {
        while (true) {
            System.out.println("Quan li giang vien:" );
            System.out.println("1. Them giang vien");
            System.out.println("2. Sua thong tin sdt");
            System.out.println("3. Tim kiem giang vien theo email");
            System.out.println("4. Tim kiem giang vien theo mon day");
            System.out.println("5. Xoa giang vien");
            System.out.println("6. Hien thi toan bo giang vien");
            System.out.println("7. Quay lai");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    themGiangVien(sc);
                    break;
                case 2:
                    suaSdtGiangVien(sc);
                    break;
                case 3:
                    timGiangVien(sc);
                    break;
                case 4:
                    timGiangVienTheoMon(sc);
                    break;
                case 5:
                    xoaGiangVien(sc);
                    break;
                case 6:
                    hienThiGiangVien();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Vui long chon lai");
            }
        }
    }
}
