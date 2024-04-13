package vn.edu.huce.ltudm.cassette.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Cassette {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String optionName;
    private String optionNhac;
    private static int gia = 230000;
    private int soluong;

    public int getid() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter và setter cho name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter và setter cho optionName
    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    // Getter và setter cho optionNhac
    public String getOptionNhac() {
        return optionNhac;
    }

    public void setOptionNhac(String optionNhac) {
        this.optionNhac = optionNhac;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    @OneToOne
    @JoinColumn(name = "playlistid", nullable = false)
    private Playlist playlist;

    @OneToOne
    @JoinColumn(name = "linkriengid", nullable = false)
    private Linkrieng linkrieng;

    @OneToOne
    @JoinColumn(name = "maubangid", nullable = false)
    private MauBang mauBang;

    @OneToOne
    @JoinColumn(name = "maulabelid", nullable = false)
    private MauLabel mauLabel;
}
