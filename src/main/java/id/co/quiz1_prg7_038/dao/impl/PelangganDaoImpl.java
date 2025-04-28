package id.co.quiz1_prg7_038.dao.impl;

import id.co.quiz1_prg7_038.dao.PelangganDao;
import id.co.quiz1_prg7_038.model.Pelanggan;
import id.co.quiz1_prg7_038.repository.PelangganRepository;
import id.co.quiz1_prg7_038.vo.PelangganVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;

@Repository
public class PelangganDaoImpl implements PelangganDao {
    @Autowired
    private PelangganRepository pelangganRepository;

    @Override
    public List<PelangganVo> getAllDataPelanggan() {
        Iterable<Pelanggan> pelanggan = pelangganRepository.findAll();
        List<PelangganVo> pelangganVos = new ArrayList<>();
        for (Pelanggan item: pelanggan) {
            PelangganVo pelangganVo = new PelangganVo(item);
            pelangganVos.add(pelangganVo);
        }
        return pelangganVos;
    }
}
