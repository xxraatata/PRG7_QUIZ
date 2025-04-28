package id.co.quiz1_prg7_038.service;

import id.co.quiz1_prg7_038.response.DtoResponse;
import id.co.quiz1_prg7_038.vo.LayananVo;
import jakarta.transaction.Transactional;
import org.springframework.dao.DataIntegrityViolationException;


public interface LayananService {
    DtoResponse getAllLayanan();

    DtoResponse addDataLayanan(LayananVo layananVo);

    // Mengupdate data layanan
    DtoResponse editDataLayanan(LayananVo layananVo);

    // Menghapus data layanan
    DtoResponse deleteDataLayanan(LayananVo layananVo);
}
