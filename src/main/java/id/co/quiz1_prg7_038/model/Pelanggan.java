package id.co.quiz1_prg7_038.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="quiz_msPelanggan")
public class Pelanggan {
    @Id
    @Column(name = "idPelanggan", length = 10)
    private String idPelanggan;

    @Column(name = "namaPelanggan", length = 50)
    private String namaPelanggan;

    @Column(name = "nomorHP", length = 13)
    private String nomorHP;

    public Pelanggan() {
    }

    public Pelanggan(String idPelanggan, String namaPelanggan, String nomorHP) {
        this.idPelanggan = idPelanggan;
        this.namaPelanggan = namaPelanggan;
        this.nomorHP = nomorHP;
    }

    public String getIdPelanggan() {
        return idPelanggan;
    }

    public void setIdPelanggan(String idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    public String getNomorHP() {
        return nomorHP;
    }

    public void setNomorHP(String nomorHP) {
        this.nomorHP = nomorHP;
    }
}
