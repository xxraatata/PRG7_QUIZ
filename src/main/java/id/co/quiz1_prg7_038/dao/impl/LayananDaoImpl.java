package id.co.quiz1_prg7_038.dao.impl;

import id.co.quiz1_prg7_038.dao.LayananDao;
import id.co.quiz1_prg7_038.model.Layanan;
import id.co.quiz1_prg7_038.repository.LayananRepository;
import id.co.quiz1_prg7_038.vo.LayananVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LayananDaoImpl implements LayananDao {
    @Autowired
    private LayananRepository layananRepository;

    @Override
    public List<LayananVo> getAllDataLayanan() {
        Iterable<Layanan> layanans = layananRepository.findAll();
        List<LayananVo> layananVos = new ArrayList<>();
        for (Layanan item: layanans) {
            LayananVo layananVo = new LayananVo(item);
            layananVos.add(layananVo);
        }
        return layananVos;
    }
}
