package LO5_6_7;

public class SinhVien extends Person {
    private String chuyenNganh;
    private String[] monChuyenNganh;

    public SinhVien(String email, String ten, int namSinh, String gioiTinh, int sdt, String diaChi, String chuyenNganh, String[] monChuyenNganh) {
        super(email, ten, namSinh, gioiTinh, sdt, diaChi);
        this.chuyenNganh = chuyenNganh;
        this.monChuyenNganh = new String[3];
        for (int i = 0; i < 3; i++) {
            this.monChuyenNganh[i] = monChuyenNganh[i];
        }
    }

    public void xuatThongTin() {
        super.xuatThongTin();
        System.out.println("Chuyen nganh: " + chuyenNganh);
        System.out.println("Cac mon hoc: " );
        for (int i = 0; i < 3; i++) {
            System.out.println(monChuyenNganh[i]);
        }
    }

    public String getChuyenNganh() {
        return chuyenNganh;
    }
}
