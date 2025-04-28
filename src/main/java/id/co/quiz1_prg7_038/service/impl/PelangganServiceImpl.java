package id.co.quiz1_prg7_038.service.impl;

import id.co.quiz1_prg7_038.dao.PelangganDao;
import id.co.quiz1_prg7_038.model.Pelanggan;
import id.co.quiz1_prg7_038.repository.PelangganRepository;
import id.co.quiz1_prg7_038.response.DtoResponse;
import id.co.quiz1_prg7_038.service.PelangganService;
import id.co.quiz1_prg7_038.vo.PelangganVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static id.co.quiz1_prg7_038.constant.PelangganConstant.*;
@Service
@Transactional
public class PelangganServiceImpl implements PelangganService {
    @Autowired
    private PelangganDao pelangganDao;
    @Autowired
    private PelangganRepository pelangganRepository;

    @Override
    public DtoResponse getAllPelanggan() {
        if(pelangganDao.getAllDataPelanggan() != null){
            return new DtoResponse(200, pelangganDao.getAllDataPelanggan());
        }
        return new DtoResponse(200, null, mNotFound);
    }

    @Override
    public DtoResponse addDataPelanggan(PelangganVo pelangganVo) {
        try {
            Pelanggan pelanggan = new Pelanggan();
            pelanggan.setIdPelanggan(pelangganVo.getId());
            pelanggan.setNamaPelanggan(pelangganVo.getNama());
            pelanggan.setNomorHP(pelangganVo.getNoHp());

            id.co.quiz1_prg7_038.model.Pelanggan pelangganSave = pelangganRepository.save(pelanggan);
            return new DtoResponse(200, pelangganSave, "Pelanggan berhasil ditambahkan");
        } catch (Exception e) {
            return new DtoResponse(500, null, "Pelanggan gagal ditambahkan");
        }
    }

    // Mengupdate data pelanggan
    @Override
    public DtoResponse editDataPelanggan(PelangganVo pelangganVo) {
        try {
            Pelanggan existingPelanggan = pelangganRepository.findById(pelangganVo.getId())
                    .orElseThrow(() -> new Exception("Pelanggan tidak ditemukan"));

            // Update data
            existingPelanggan.setNamaPelanggan(pelangganVo.getNama());
            existingPelanggan.setNomorHP(pelangganVo.getNoHp());

            Pelanggan updatedPelanggan = pelangganRepository.save(existingPelanggan);
            return new DtoResponse(200, updatedPelanggan, "Pelanggan berhasil diupdate");
        } catch (Exception e) {
            return new DtoResponse(500, null, "Pelanggan gagal diupdate: " + e.getMessage());
        }
    }

    // Menghapus data pelanggan
    @Override
    public DtoResponse deleteDataPelanggan(PelangganVo pelangganVo) {
        try {
            Pelanggan pelanggan = pelangganRepository.findById(pelangganVo.getId())
                    .orElseThrow(() -> new Exception("Pelanggan tidak ditemukan"));

            // Menghapus pelanggan
            pelangganRepository.delete(pelanggan);
            return new DtoResponse(200, pelangganVo, "Pelanggan berhasil dihapus");
        } catch (Exception e) {
            return new DtoResponse(500, null, "Pelanggan gagal dihapus");
        }
    }
}
