package id.co.quiz1_prg7_038.vo;

import id.co.quiz1_prg7_038.model.Pembayaran;

import java.util.Date;


public class PembayaranVo {
    private String idPelanggan;
    private String namaPelanggan;
    private Integer idLayanan;
    private Integer idSeqPembayaran;
    private Integer biayaPembayaran;
    private Date tanggal;

    public PembayaranVo() {
    }

    public PembayaranVo(Pembayaran pembayaran) {
        this.idPelanggan = pembayaran.getPembayaranPK().getIdPelanggan();
        this.idLayanan = pembayaran.getPembayaranPK().getIdJenisLayanan();
        this.idSeqPembayaran = pembayaran.getPembayaranPK().getIdSeqPembayaran();
        this.biayaPembayaran = pembayaran.getBiayaBayar();
        this.tanggal = pembayaran.getTanggal();
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

    public Integer getIdLayanan() {
        return idLayanan;
    }

    public void setIdLayanan(Integer idLayanan) {
        this.idLayanan = idLayanan;
    }

    public Integer getIdSeqPembayaran() {
        return idSeqPembayaran;
    }

    public void setIdSeqPembayaran(Integer idSeqPembayaran) {
        this.idSeqPembayaran = idSeqPembayaran;
    }

    public Integer getBiayaPembayaran() {
        return biayaPembayaran;
    }

    public void setBiayaPembayaran(Integer biayaPembayaran) {
        this.biayaPembayaran = biayaPembayaran;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }
}
