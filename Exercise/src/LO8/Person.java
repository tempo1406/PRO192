package LO8;

public abstract class Person {
    protected String email;
    protected String ten;
    protected String sdt;

    public Person(String email, String ten, String sdt) {
        this.email = email;
        this.ten = ten;
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    @Override
    public String toString() {
        return "Ten: " + ten + ", Email: " + email + ", SDT: " + sdt;
    }
}
