package LO8;

public class GiangVien extends Person {
    private String monDay;

    public GiangVien(String email, String ten, String sdt, String monDay) {
        super(email, ten, sdt);
        this.monDay = monDay;
    }

    public String getMonDay() {
        return monDay;
    }

    @Override
    public String toString() {
        return super.toString() + ", mon day: " + monDay;
    }
}
