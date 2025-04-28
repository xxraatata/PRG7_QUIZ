package id.co.quiz1_prg7_038.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class PembayaranPK implements Serializable {
    @Column(name = "idPelanggan")
    private String idPelanggan;

    @Column(name = "idJenisLayanan")
    private Integer idJenisLayanan;

    @Column(name = "idSeqPembayaran")
    private Integer idSeqPembayaran;

    public PembayaranPK() {
    }

    public PembayaranPK(String idPelanggan, Integer idJenisLayanan, Integer idSeqPembayaran) {
        this.idPelanggan = idPelanggan;
        this.idJenisLayanan = idJenisLayanan;
        this.idSeqPembayaran = idSeqPembayaran;
    }

    public String getIdPelanggan() {
        return idPelanggan;
    }

    public void setIdPelanggan(String idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    public Integer getIdJenisLayanan() {
        return idJenisLayanan;
    }

    public void setIdJenisLayanan(Integer idJenisLayanan) {
        this.idJenisLayanan = idJenisLayanan;
    }

    public Integer getIdSeqPembayaran() {
        return idSeqPembayaran;
    }

    public void setIdSeqPembayaran(Integer idSeqPembayaran) {
        this.idSeqPembayaran = idSeqPembayaran;
    }
}
