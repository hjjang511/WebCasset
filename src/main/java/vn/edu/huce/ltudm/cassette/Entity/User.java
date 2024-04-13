package vn.edu.huce.ltudm.cassette.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;
    private String password;
    private String email;
    private String phone;
    private String address;
    private String name;

    public void setId(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setusername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setpassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setphone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public void setaddress(String address) {
        this.address = address;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    @OneToOne
    @JoinColumn(name = "giohangid", nullable = false)
    private GioHang gioHang;

    @ManyToOne
    @JoinColumn(name = "hoadonid", nullable = false)
    private HoaDon hoaDon;
}
