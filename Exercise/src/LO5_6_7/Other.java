package LO5_6_7;

import java.util.Vector;

public class Other {
    private int soPerson;
    private Person[] mangPerson;

    public Other() {
        soPerson = 5;
        mangPerson = new Person[soPerson];
        mangPerson[0] = new GiangVien("nnt", "Toan", 2004, "Male", 1234, "QN", 3, new String[]{"Java", "C++", "Python"});
        mangPerson[1] = new GiangVien("dav", "Vu", 2004, "Male", 456, "HCM", 3, new String[]{"CSI", "Python", "C"});
        mangPerson[2] = new GiangVien("nnm", "Minh", 2006, "Male", 7893, "QB", 3, new String[]{"MAE", "C++", "MAD"});
        mangPerson[3] = new SinhVien("ntl","Linh",2004, "Female", 4162,"HN", "SE", new String[]{"Java", "C++", "C"});
        mangPerson[4] = new SinhVien("dnmt", "Tam", 2005, "Female", 2362, "Hue", "AI", new String[]{"MAD", "MAE", "CSI"});
    }

    public Person timGiangVienTheoEmail(String mail) {
        for (int i = 0; i < soPerson; i++) {
            if (mangPerson[i].getEmail() == mail)
                return mangPerson[i];
        }
        return null;
    }

    public Vector<Person> timMonHoc(String monHoc) {
        Vector<Person> danhSachGiangVien = new Vector<>();
        for (int i = 0; i < soPerson; i++) {
            if (mangPerson[i] instanceof GiangVien) {
                GiangVien giangVien = (GiangVien) mangPerson[i];
                for (String mon : giangVien.getDanhSachMonHoc()) {
                    if (mon == monHoc) {
                        danhSachGiangVien.add(giangVien);
                    }
                }
            }
        }
        return danhSachGiangVien;
    }

    public Person timSinhVienTheoEmail(String mail) {
        for(int i = 0; i < soPerson; i++) {
            if(mangPerson[i].getEmail() == mail) {
                return mangPerson[i];
            }
        }
        return null;
    }

    public Vector<Person> timChuyenNganh(String chuyenNganh) {
        Vector<Person> danhSachSinhVien = new Vector<>();
        for (int i = 0; i < soPerson; i++) {
            if (mangPerson[i] instanceof SinhVien) {
                if (((SinhVien) mangPerson[i]).getChuyenNganh() == chuyenNganh)
                    danhSachSinhVien.add(mangPerson[i]);
            }
        }
        return danhSachSinhVien;
    }
}
