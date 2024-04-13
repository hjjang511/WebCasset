package vn.edu.huce.ltudm.cassette.Entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int MaDon;
    private int optionGiaoHang;
    private Date time;
    private String ghichu;
    private String img;
    private int status;
    // Các phương thức getter và setter cho các trường

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaDon() {
        return MaDon;
    }

    public void setMaDon(int maDon) {
        MaDon = maDon;
    }

    public int getOptionGiaoHang() {
        return optionGiaoHang;
    }

    public void setOptionGiaoHang(int optionGiaoHang) {
        this.optionGiaoHang = optionGiaoHang;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @OneToOne
    @JoinColumn(name = "giohangid", nullable = false)
    private GioHang gioHang;

    @ManyToOne
    @JoinColumn(name = "cassetteid", nullable = false)
    private Cassette cassette;

    @OneToOne
    @JoinColumn(name = "userid", nullable = false)
    private User user;

    @OneToOne
    @JoinColumn(name = "nguoinhanhoid", nullable = false)
    private NguoiNhanHo nguoiNhanHo;
}
