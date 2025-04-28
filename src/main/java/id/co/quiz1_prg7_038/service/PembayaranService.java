package id.co.quiz1_prg7_038.service;

import id.co.quiz1_prg7_038.response.DtoResponse;
import id.co.quiz1_prg7_038.vo.PembayaranVoForm;

public interface PembayaranService {
    DtoResponse getAllTransaksiPembayaran();
    DtoResponse addDataTransaksiPembayaran(PembayaranVoForm pembayaranVoForm);
    DtoResponse editDataTransaksiPembayaran(PembayaranVoForm pembayaranVoForm);
    DtoResponse deleteDataTransaksiPembayaran(PembayaranVoForm pembayaranVoForm);
}
