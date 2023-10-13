package LO8;

import java.util.ArrayList;
import java.util.Scanner;

public class ItemList {
    public static ArrayList<GiangVien> giangVien = new ArrayList<>();
    public static ArrayList<SinhVien> sinhVien = new ArrayList<>();

    public static void themGiangVien(Scanner sc) {
        System.out.print("Nhap email: ");
        String email = sc.nextLine();
        System.out.print("Nhap ten: ");
        String ten = sc.nextLine();
        System.out.print("Nhap sdt: ");
        String sdt = sc.nextLine();
        System.out.print("Nhap mon day : ");
        String monDay = sc.nextLine();
        GiangVien gv = new GiangVien(email, ten, sdt, monDay);
        giangVien.add(gv);
    }

    public static void themSinhVien(Scanner sc) {
        System.out.print("Nhap email: ");
        String email = sc.nextLine();
        System.out.print("Nhap ten: ");
        String ten = sc.nextLine();
        System.out.print("Nhap sdt: ");
        String sdt = sc.nextLine();
        System.out.print("Nhap chuyen nganh: ");
        String chuyenNganh = sc.nextLine();
        SinhVien sv = new SinhVien(email, ten, sdt,chuyenNganh);
        sinhVien.add(sv);
    }

    public static void timGiangVien(Scanner sc) {
        System.out.print("Nhap email giang vien can tim: ");
        String emailMoi = sc.nextLine();

        for(GiangVien gv : giangVien) {
            if (gv.getEmail().equals(emailMoi)) {
                System.out.println("Thong tin giang vien: ");
                System.out.println(gv);
            }
         }
    }

    public static void timSinhVien(Scanner sc) {
        System.out.print("Nhap email sinh vien can tim: ");
        String emailMoi = sc.nextLine();

        for(SinhVien sv : sinhVien) {
            if (sv.getEmail().equals(emailMoi)) {
                System.out.println("Thong tin sinh vien: ");
                System.out.println(sv);
            }
        }
    }

    public static void suaSdtGiangVien(Scanner sc) {
        System.out.print("Nhap mail cua giang vien can doi sdt: ");
        String emailMoi = sc.nextLine();

        for(GiangVien gv : giangVien) {
            if (gv.getEmail().equals(emailMoi)) {
                System.out.println("Nhap sdt moi cho giang vien: ");
                String sdtMoi = sc.nextLine();
                gv.setSdt(sdtMoi);
            }
        }
    }

    public static void suaSdtSinhVien(Scanner sc) {
        System.out.print("Nhap mail cua sinh vien can doi sdt: ");
        String emailMoi = sc.nextLine();

        for(SinhVien sv : sinhVien) {
            if (sv.getEmail().equals(emailMoi)) {
                System.out.println("Nhap sdt moi cho sinh vien: ");
                String sdtMoi = sc.nextLine();
                sv.setSdt(sdtMoi);
            }
        }
    }

    public static void timGiangVienTheoMon(Scanner sc) {
        System.out.print("Nhap mon day can tim giang vien: ");
        String monDayMoi = sc.nextLine();

        for(GiangVien gv : giangVien) {
            if(gv.getMonDay().equals(monDayMoi)) {
                System.out.println("Thong tin giang vien: ");
                System.out.println(gv);
            }
        }
    }

    public static void timSinhVienTheoCN(Scanner sc) {
        System.out.print("Nhap chuyen nganh can tim sinh vien: ");
        String chuyenNganhMoi = sc.nextLine();

        for (SinhVien sv : sinhVien) {
            if(sv.getChuyenNganh().equals(chuyenNganhMoi)) {
                System.out.println("Thong tin sinh vien: ");
                System.out.println(sv);
            }
        }
    }

    public static void xoaGiangVien(Scanner sc) {
        System.out.print("Nhap mail can xoa giang vien");
        String emailMoi = sc.nextLine();

        for (GiangVien gv : giangVien) {
            if (gv.getEmail().equals(emailMoi)) {
                giangVien.remove(gv);
                System.out.println("Da xoa giang vien");
                return;
            }
        }
    }

    public static void xoaSinhVien(Scanner sc) {
        System.out.print("Nhap mail can xoa sinh vien");
        String emailMoi = sc.nextLine();

        for (SinhVien sv: sinhVien) {
            if (sv.getEmail().equals(emailMoi)) {
                sinhVien.remove(sv);
                System.out.println("Da xoa sinh vien");
                return;
            }
        }
    }

    public static void hienThiGiangVien() {
        System.out.println("Danh sach giang vien: ");
        for (GiangVien gv : giangVien) {
            System.out.println(gv);
        }
    }

    public static void hienThiSinhVien() {
        System.out.println("Danh sach sinh vien: ");
        for (SinhVien sv : sinhVien) {
            System.out.println(sv);
        }
    }
}
