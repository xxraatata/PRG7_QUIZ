package id.co.quiz1_prg7_038.service.impl;

import id.co.quiz1_prg7_038.dao.PembayaranDao;
import id.co.quiz1_prg7_038.model.Layanan;
import id.co.quiz1_prg7_038.model.Pelanggan;
import id.co.quiz1_prg7_038.model.Pembayaran;
import id.co.quiz1_prg7_038.model.PembayaranPK;
import id.co.quiz1_prg7_038.repository.LayananRepository;
import id.co.quiz1_prg7_038.repository.PelangganRepository;
import id.co.quiz1_prg7_038.repository.PembayaranRepository;
import id.co.quiz1_prg7_038.response.DtoResponse;
import id.co.quiz1_prg7_038.service.PembayaranService;
import id.co.quiz1_prg7_038.vo.PembayaranVo;
import id.co.quiz1_prg7_038.vo.PembayaranVoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static id.co.quiz1_prg7_038.constant.PembayaranConstant.*;

@Service
@Transactional
public class PembayaranServiceImpl implements PembayaranService {
    @Autowired
    private PembayaranDao pembayaranDao;
    @Autowired
    private PembayaranRepository pembayaranRepository;
    @Autowired
    private PelangganRepository pelangganRepository;
    @Autowired
    private LayananRepository layananRepository;

    @Override
    public DtoResponse getAllTransaksiPembayaran() {
        List<PembayaranVo> pembayaranVos = new ArrayList<>();
        List<Pembayaran> pembayarans = pembayaranRepository.findAll();

        if(pembayarans != null){
            for (Pembayaran p : pembayarans) {
                PembayaranVo pembayaranVo = new PembayaranVo(p);

                Pelanggan pelanggan = pelangganRepository.findById(p.getPembayaranPK().getIdPelanggan()).orElseThrow();
                pembayaranVo.setNamaPelanggan(pelanggan.getNamaPelanggan());

                Layanan layanan = layananRepository.findById(p.getPembayaranPk().getIdJenisLayanan()).orElseThrow();
                pembayaranVo.setJenisLayanan(layanan.getJenisLayanan());

                pembayaranVos.add(pembayaranVo);
            }
            return new DtoResponse(200, pembayaranVos, null);
        }
        return new DtoResponse(200, null, mNotFound);
    }

    @Override
    public DtoResponse addDataTransaksiPembayaran(PembayaranVoForm pembayaranVoForm) {
        try{
            PembayaranPK pembayaranPK = new PembayaranPK();
            pembayaranPK.setIdPelanggan(pembayaranVoForm.getIdPelanggan());
            pembayaranPK.setIdJenisLayanan(pembayaranVoForm.getIdJenisLayanan());
            pembayaranPK.setIdSeqPembayaran(pembayaranVoForm.getIdSeqPembayaran());

            Pembayaran pembayaran = new Pembayaran();
            pembayaran.setPembayaranPK(pembayaranPK);
            pembayaran.setBiayaBayar(pembayaranVoForm.getBiayaBayar());
            pembayaran.setTanggal(pembayaranVoForm.getTanggal());

            id.co.quiz1_prg7_038.model.Pembayaran trsPembayaran = pembayaranRepository.save(pembayaran);
            return new DtoResponse(200,trsPembayaran, mCreateSuccess);
        } catch (Exception e){
            return new DtoResponse(500, e, mCreateFailed);
        }
    }

    @Override
    public DtoResponse editDataTransaksiPembayaran(PembayaranVoForm pembayaranVoForm) {
        try {
            PembayaranPK pembayaranPK = new PembayaranPK();
            pembayaranPK.setIdPelanggan(pembayaranVoForm.getIdPelanggan());
            pembayaranPK.setIdJenisLayanan(pembayaranVoForm.getIdJenisLayanan());
            pembayaranPK.setIdSeqPembayaran(pembayaranVoForm.getIdSeqPembayaran());

            // CARI DULU, BUKAN LANGSUNG BUAT OBJEK BARU
            Pembayaran existingPembayaran = pembayaranRepository.findById(pembayaranPK)
                    .orElseThrow(() -> new RuntimeException("Data pembayaran tidak ditemukan"));

            // UPDATE FIELD yang boleh diedit
            existingPembayaran.setBiayaBayar(pembayaranVoForm.getBiayaBayar());
            existingPembayaran.setTanggal(pembayaranVoForm.getTanggal());

            Pembayaran updatedPembayaran = pembayaranRepository.save(existingPembayaran);

            return new DtoResponse(200, updatedPembayaran, mUpdateSuccess);
        } catch (Exception e) {
            return new DtoResponse(500, null, mUpdateFailed);
        }
    }

    @Override
    public DtoResponse deleteDataTransaksiPembayaran(PembayaranVoForm pembayaranVoForm) {
        PembayaranPK trsPembayaranPK = new PembayaranPK();
        trsPembayaranPK.setIdPelanggan(pembayaranVoForm.getIdPelanggan());
        trsPembayaranPK.setIdJenisLayanan(pembayaranVoForm.getIdJenisLayanan());
        trsPembayaranPK.setIdSeqPembayaran(pembayaranVoForm.getIdSeqPembayaran());

        Pembayaran pembayaran = pembayaranRepository.findById(trsPembayaranPK).orElseThrow();
        if(pembayaran != null){
            try{
                pembayaranRepository.delete(pembayaran);
                return new DtoResponse(200, pembayaranVoForm, mDeleteSuccess);
            } catch (Exception e){
                return new DtoResponse(500, pembayaranVoForm, mDeleteFailed);
            }
        }
        return new DtoResponse(404, null, mNotFound);
    }
}
