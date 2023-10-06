package LO5_6_7;

import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Other a = new Other();

        System.out.println("Tim giang vien theo email: ");
        a.timGiangVienTheoEmail("nnm").xuatThongTin();

        System.out.println("Tim giang vien theo mon hoc");
        Vector<Person> giangVienTheoMonHoc = a.timMonHoc("C++");
        for (Person giangVien : giangVienTheoMonHoc) {
            giangVien.xuatThongTin();
        }

        System.out.println("Tim sinh vien theo email");
        a.timSinhVienTheoEmail("dnmt").xuatThongTin();

        System.out.println("Tim sinh vien theo chuyen nganh");
        Vector<Person> sinhVienTheoChuyenNganh = a.timChuyenNganh("SE");
        for (Person sinhVien : sinhVienTheoChuyenNganh) {
            sinhVien.xuatThongTin();
        }
    }
}

