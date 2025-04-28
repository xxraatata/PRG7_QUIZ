package id.co.quiz1_prg7_038.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.sql.Date;


@Entity
@Table(name ="quiz_trsPembayaran")
public class Pembayaran implements Serializable {
    @EmbeddedId
    private PembayaranPK pembayaranPK;

    @Column(name = "BiayaBayar")
    private Integer biayaBayar;

    @Column(name = "Tanggal")
    private Date tanggal;

    public PembayaranPK getPembayaranPk(){
        return pembayaranPK;
    }

    public Pembayaran() {
    }

    public Pembayaran(PembayaranPK pembayaranPK, Integer biayaBayar, Date tanggal) {
        this.pembayaranPK = pembayaranPK;
        this.biayaBayar = biayaBayar;
        this.tanggal = tanggal;
    }

    public PembayaranPK getPembayaranPK() {
        return pembayaranPK;
    }

    public void setPembayaranPK(PembayaranPK pembayaranPK) {
        this.pembayaranPK = pembayaranPK;
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
