package model;

public class Lecturers {
    private String email;
    private String passWord;
    private String fullName;
    private String address;
    private String subject;

    public Lecturers() {
    }

    public Lecturers(String email, String passWord, String fullName, String address, String subject) {
        this.email = email;
        this.passWord = passWord;
        this.fullName = fullName;
        this.address = address;
        this.subject = subject;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Lecturers{" +
                "email='" + email + '\'' +
                ", passWord='" + passWord + '\'' +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }

    public void changePassWord(String oldPass, String newPass) {
        if(oldPass.equals(passWord)) {
            passWord = newPass;
            System.out.println("Change pass word successfully !");
        } else
            System.out.println("Change pass word failed !");
    }
}
