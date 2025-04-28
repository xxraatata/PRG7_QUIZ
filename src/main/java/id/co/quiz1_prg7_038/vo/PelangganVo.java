package id.co.quiz1_prg7_038.vo;

import id.co.quiz1_prg7_038.model.Pelanggan;

public class PelangganVo {

    private String id;
    private String nama;
    private String noHp;

    public PelangganVo() {
    }

    public PelangganVo(Pelanggan pelanggan) {
        this.id = pelanggan.getIdPelanggan();
        this.nama = pelanggan.getNamaPelanggan();
        this.noHp = pelanggan.getNomorHP();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }
}
