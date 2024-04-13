package vn.edu.huce.ltudm.cassette.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    private String type;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] imageData;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "maubang_id")
    private MauBang mauBang;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "maulabel_id")
    private MauLabel mauLabel;

}
