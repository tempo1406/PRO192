package LO5_6_7;

public class GiangVien extends Person {
    private int soMonHoc;
    private String[] danhSachMonHoc;

    public GiangVien(String email, String ten, int namSinh, String gioiTinh, int sdt, String diaChi, int soMonHoc, String[] danhSachMonHoc) {
        super(email, ten, namSinh, gioiTinh, sdt, diaChi);
        this.soMonHoc = soMonHoc;
        this.danhSachMonHoc = new String[soMonHoc];
        for (int i = 0; i < soMonHoc; i++) {
            this.danhSachMonHoc[i] = danhSachMonHoc[i];
        }
    }
    public void xuatThongTin() {
        super.xuatThongTin();
        System.out.println("So mon hoc: " + soMonHoc);
        System.out.println("Cac mon hoc: ");
        for (int i = 0; i < soMonHoc; i++) {
            System.out.println(danhSachMonHoc[i]);
        }
    }


    public String[] getDanhSachMonHoc() {
        return danhSachMonHoc;
    }

}
