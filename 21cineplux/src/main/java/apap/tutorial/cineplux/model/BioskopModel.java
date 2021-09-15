package apap.tutorial.cineplux.model;

import java.util.Objects;

public class BioskopModel {
    private String idBioskop;
    private String namaBioskop;
    private String alamat;
    private String noTelepon;
    private int jumlahStudio;

    public BioskopModel(String idBioskop, String namaBioskop, String alamat, String noTelepon, int jumlahStudio) {
        this.idBioskop = idBioskop;
        this.namaBioskop = namaBioskop;
        this.alamat = alamat;
        this.noTelepon = noTelepon;
        this.jumlahStudio = jumlahStudio;
    }

    public String getIdBioskop() {
        return idBioskop;
    }

    public void setIdBioskop(String idBioskop) {
        this.idBioskop = idBioskop;
    }

    public String getNamaBioskop() {
        return namaBioskop;
    }

    public void setNamaBioskop(String namaBioskop) {
        this.namaBioskop = namaBioskop;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }

    public int getJumlahStudio() {
        return jumlahStudio;
    }

    public void setJumlahStudio(int jumlahStudio) {
        this.jumlahStudio = jumlahStudio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BioskopModel that = (BioskopModel) o;
        return jumlahStudio == that.jumlahStudio && Objects.equals(idBioskop, that.idBioskop) && Objects.equals(namaBioskop, that.namaBioskop) && Objects.equals(alamat, that.alamat) && Objects.equals(noTelepon, that.noTelepon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBioskop, namaBioskop, alamat, noTelepon, jumlahStudio);
    }
}
