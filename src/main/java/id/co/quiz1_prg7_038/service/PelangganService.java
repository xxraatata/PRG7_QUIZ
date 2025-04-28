package id.co.quiz1_prg7_038.service;

import id.co.quiz1_prg7_038.response.DtoResponse;
import id.co.quiz1_prg7_038.vo.PelangganVo;

public interface PelangganService {
    DtoResponse getAllPelanggan();

    DtoResponse addDataPelanggan(PelangganVo pelangganVo);

    // Mengupdate data pelanggan
    DtoResponse editDataPelanggan(PelangganVo pelangganVo);

    // Menghapus data pelanggan
    DtoResponse deleteDataPelanggan(PelangganVo pelangganVo);
}
