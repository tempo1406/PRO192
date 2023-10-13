package LO8;

public class SinhVien extends Person {
    private String chuyenNganh;


    public SinhVien(String email, String ten, String sdt, String chuyenNganh) {
        super(email, ten, sdt);
        this.chuyenNganh = chuyenNganh;

    }

    public String getChuyenNganh() {
        return chuyenNganh;
    }

    @Override
    public String toString() {
        return super.toString() + ", chuyen nganh: " + chuyenNganh;
    }
}
