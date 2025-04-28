package id.co.quiz1_prg7_038.vo;

import id.co.quiz1_prg7_038.model.Layanan;
import org.springframework.data.relational.core.sql.In;

public class LayananVo {
    private Integer idJenisLayanan;
    private String jenisLayanan;
    private Integer biaya;

    public LayananVo() {
    }

    public LayananVo(Layanan layanan) {
        this.idJenisLayanan = layanan.getIdJenisLayanan();
        this.jenisLayanan = layanan.getJenisLayanan();
        this.biaya = layanan.getBiaya();
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

