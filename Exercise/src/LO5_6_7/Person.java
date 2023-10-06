package LO5_6_7;

public abstract class Person {
    protected String email;
    protected String ten;
    protected int namSinh;
    protected String gioiTinh;
    protected int sdt;
    protected String diaChi;

    public Person(String email, String ten, int namSinh, String gioiTinh, int sdt, String diaChi) {
        this.email = email;
        this.ten = ten;
        this.namSinh = namSinh;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.diaChi = diaChi;
    }

    public void xuatThongTin() {
        System.out.println("Email: " + email);
        System.out.println("Ten:" + ten);
        System.out.println("Nam sinh: " + namSinh);
        System.out.println("Gioi tinh: " + gioiTinh);
        System.out.println("So dien thoai: " + sdt);
        System.out.println("Dia chi: " + diaChi);
    }

    public String getEmail() {
        return email;
    }

}
