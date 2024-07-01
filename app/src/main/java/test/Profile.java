package test;

import java.io.Serializable;

public class Profile implements Serializable {
    String Fullname,Email,phone,type;
    private static final long serialVersionUID = 2L;

    public Profile(String fullname, String type, String phone, String email) {
        Fullname = fullname;
        this.type = type;
        this.phone = phone;
        Email = email;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String fullname) {
        Fullname = fullname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
