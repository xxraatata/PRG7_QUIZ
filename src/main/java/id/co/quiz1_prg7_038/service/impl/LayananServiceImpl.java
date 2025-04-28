package id.co.quiz1_prg7_038.service.impl;

import id.co.quiz1_prg7_038.dao.LayananDao;
import id.co.quiz1_prg7_038.model.Layanan;
import id.co.quiz1_prg7_038.repository.LayananRepository;
import id.co.quiz1_prg7_038.response.DtoResponse;
import id.co.quiz1_prg7_038.service.LayananService;
import id.co.quiz1_prg7_038.service.PelangganService;
import id.co.quiz1_prg7_038.vo.LayananVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static id.co.quiz1_prg7_038.constant.PelangganConstant.mNotFound;

@Service
@Transactional
public class LayananServiceImpl implements LayananService {
    @Autowired
    private LayananDao layananDao;

    @Autowired
    private LayananRepository layananRepository;

    @Override
    public DtoResponse getAllLayanan() {
        if(layananDao.getAllDataLayanan() != null){
            return new DtoResponse(200, layananDao.getAllDataLayanan());
        }
        return new DtoResponse(200, null, mNotFound);
    }
    @Override
    public DtoResponse addDataLayanan(LayananVo layananVo) {
        try {
            Layanan layanan = new Layanan();
            layanan.setJenisLayanan(layananVo.getJenisLayanan());
            layanan.setBiaya(layananVo.getBiaya());

            Layanan savedLayanan = layananRepository.save(layanan);
            return new DtoResponse(200, savedLayanan, "Layanan berhasil ditambahkan");
        } catch (Exception e) {
            return new DtoResponse(500, null, "Layanan gagal ditambahkan");
        }
    }

    // Mengupdate data layanan
    @Override
    public DtoResponse editDataLayanan(LayananVo layananVo) {
        try {
            Layanan layanan = layananRepository.findById(layananVo.getIdJenisLayanan())
                    .orElseThrow(() -> new Exception("Layanan tidak ditemukan"));

            layanan.setJenisLayanan(layananVo.getJenisLayanan());
            layanan.setBiaya(layananVo.getBiaya());

            Layanan updatedLayanan = layananRepository.save(layanan);
            return new DtoResponse(200, updatedLayanan, "Layanan berhasil diupdate");
        } catch (Exception e) {
            return new DtoResponse(500, null, "Layanan gagal diupdate");
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public DtoResponse deleteDataLayanan(LayananVo layananVo) {
        try {
            // Memastikan ID yang diberikan ada di database
            Layanan layanan = layananRepository.findById(layananVo.getIdJenisLayanan())
                    .orElseThrow(() -> new RuntimeException("Layanan tidak ditemukan"));

            // Menghapus layanan
            layananRepository.delete(layanan);
            return new DtoResponse(200, layananVo, "Layanan berhasil dihapus");
        } catch (Exception e) {
            // Tangani exception dan beri feedback yang jelas
            return new DtoResponse(500, null, "Gagal menghapus layanan: " + e.getMessage());
        }
    }


}

