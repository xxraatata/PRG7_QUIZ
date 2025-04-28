package id.co.quiz1_prg7_038.dao.impl;

import id.co.quiz1_prg7_038.dao.PembayaranDao;
import id.co.quiz1_prg7_038.model.Pelanggan;
import id.co.quiz1_prg7_038.model.Pembayaran;
import id.co.quiz1_prg7_038.repository.LayananRepository;
import id.co.quiz1_prg7_038.repository.PelangganRepository;
import id.co.quiz1_prg7_038.repository.PembayaranRepository;
import id.co.quiz1_prg7_038.vo.PembayaranVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class PembayaranDaoImpl implements PembayaranDao {
    @Autowired
    private PembayaranRepository pembayaranRepository;

    @Autowired
    private PelangganRepository pelangganRepository;

    @Autowired
    private LayananRepository layananRepository;

    @Override
    public List<PembayaranVo> getAllDataPembayaran() {
        Iterable<Pembayaran> pembayarans = pembayaranRepository.findAll();
        List<PembayaranVo> pembayaranVos = new ArrayList<>();
        for (Pembayaran item: pembayarans) {
            PembayaranVo pembayaranVo = new PembayaranVo(item);

            Pelanggan pelanggan = pelangganRepository.findById(pembayaranVo.getIdPelanggan()).orElseThrow();
            pembayaranVo.setNamaPelanggan(pelanggan.getNamaPelanggan());

            pembayaranVos.add(pembayaranVo);
        }
        return pembayaranVos;
    }
}
