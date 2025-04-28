package id.co.quiz1_prg7_038.vo;

import id.co.quiz1_prg7_038.model.Pembayaran;
import org.springframework.data.relational.core.sql.In;

import java.sql.Date;


public class PembayaranVoForm {
    private String idPelanggan;
    private Integer idJenisLayanan;
    private Integer idSeqPembayaran;
    private Integer biayaBayar;
    private Date tanggal;

    public PembayaranVoForm() {
    }

    public PembayaranVoForm(Pembayaran pembayaran) {
        this.idPelanggan = pembayaran.getPembayaranPK().getIdPelanggan();
        this.idJenisLayanan = pembayaran.getPembayaranPK().getIdJenisLayanan();
        this.idSeqPembayaran = pembayaran.getPembayaranPK().getIdSeqPembayaran();
        this.biayaBayar = pembayaran.getBiayaBayar();
        this.tanggal = pembayaran.getTanggal();
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

    public Integer getBiayaBayar() {
        return biayaBayar;
    }

    public void setBiayaBayar(Integer biayaBayar) {
        this.biayaBayar = biayaBayar;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }
}
