package id.co.quiz1_prg7_038.model;

import jakarta.persistence.*;
import org.springframework.data.relational.core.sql.In;

@Entity
@Table(name ="quiz_msLayanan")
public class Layanan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idJenisLayanan")
    private Integer idJenisLayanan;

    @Column(name = "jenisLayanan", length = 30)
    private String jenisLayanan;

    @Column(name = "Biaya")
    private Integer biaya;

    public Layanan() {
    }

    public Layanan(Integer idJenisLayanan, String jenisLayanan, Integer biaya) {
        this.idJenisLayanan = idJenisLayanan;
        this.jenisLayanan = jenisLayanan;
        this.biaya = biaya;
    }

    public Integer getIdJenisLayanan() {
        return idJenisLayanan;
    }

    public void setIdJenisLayanan(Integer idJenisLayanan) {
        this.idJenisLayanan = idJenisLayanan;
    }

    public String getJenisLayanan() {
        return jenisLayanan;
    }

    public void setJenisLayanan(String jenisLayanan) {
        this.jenisLayanan = jenisLayanan;
    }

    public Integer getBiaya() {
        return biaya;
    }

    public void setBiaya(Integer biaya) {
        this.biaya = biaya;
    }
}
