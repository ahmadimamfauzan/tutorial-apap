package apap.tutorial.cineplux.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@Entity
@Table(name = "bioskop")
public class BioskopModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noBioskop;

    @NotNull
    @Size(max=30)
    @Column(nullable = false)
    private String namaBioskop;

    @NotNull
    @Size(max=50)
    @Column(nullable=false)
    private String alamatBioskop;

    @NotNull
    @Column(nullable = false)
    private Integer jumlahStudio;

    @NotNull
    @Column(nullable = false)
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime waktuBuka;

    @NotNull
    @Column(nullable = false)
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime waktuTutup;

    //Relasi dengan PenjagaModel
    @OneToMany(mappedBy = "bioskop", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PenjagaModel> listPenjaga;

    //Relasi dengan FilmModel
    @ManyToMany
    @JoinTable(
            name = "film_bioskop",
            joinColumns = @JoinColumn(name = "no_bioskop"),
            inverseJoinColumns = @JoinColumn(name = "no_film"))
    List<FilmModel> listFilm;
}

//package apap.tutorial.cineplux.model;
//
//import java.util.Objects;
//
//public class BioskopModel {
//    private String idBioskop;
//    private String namaBioskop;
//    private String alamat;
//    private String noTelepon;
//    private int jumlahStudio;
//
//    public BioskopModel(String idBioskop, String namaBioskop, String alamat, String noTelepon, int jumlahStudio) {
//        this.idBioskop = idBioskop;
//        this.namaBioskop = namaBioskop;
//        this.alamat = alamat;
//        this.noTelepon = noTelepon;
//        this.jumlahStudio = jumlahStudio;
//    }
//
//    public String getIdBioskop() {
//        return idBioskop;
//    }
//
//    public void setIdBioskop(String idBioskop) {
//        this.idBioskop = idBioskop;
//    }
//
//    public String getNamaBioskop() {
//        return namaBioskop;
//    }
//
//    public void setNamaBioskop(String namaBioskop) {
//        this.namaBioskop = namaBioskop;
//    }
//
//    public String getAlamat() {
//        return alamat;
//    }
//
//    public void setAlamat(String alamat) {
//        this.alamat = alamat;
//    }
//
//    public String getNoTelepon() {
//        return noTelepon;
//    }
//
//    public void setNoTelepon(String noTelepon) {
//        this.noTelepon = noTelepon;
//    }
//
//    public int getJumlahStudio() {
//        return jumlahStudio;
//    }
//
//    public void setJumlahStudio(int jumlahStudio) {
//        this.jumlahStudio = jumlahStudio;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        BioskopModel that = (BioskopModel) o;
//        return jumlahStudio == that.jumlahStudio && Objects.equals(idBioskop, that.idBioskop) && Objects.equals(namaBioskop, that.namaBioskop) && Objects.equals(alamat, that.alamat) && Objects.equals(noTelepon, that.noTelepon);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(idBioskop, namaBioskop, alamat, noTelepon, jumlahStudio);
//    }
//}
