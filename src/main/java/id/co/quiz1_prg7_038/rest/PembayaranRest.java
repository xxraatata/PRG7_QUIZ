package id.co.quiz1_prg7_038.rest;

import id.co.quiz1_prg7_038.response.DtoResponse;
import id.co.quiz1_prg7_038.service.PembayaranService;
import id.co.quiz1_prg7_038.vo.PembayaranVoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pembayaran")
public class PembayaranRest {
    @Autowired
    private PembayaranService pembayaranService;

    public PembayaranRest(PembayaranService pembayaranService) {
        this.pembayaranService = pembayaranService;
    }

    @GetMapping("getTransaksiPembayaran")
    public DtoResponse getTransaksiPembayaran() {
        return pembayaranService.getAllTransaksiPembayaran();
    }

    @PostMapping("/saveTransaksiPembayaran")
    public DtoResponse createTransaksiPembayaran(@RequestBody PembayaranVoForm trsPembayaranVoForm) {
        return pembayaranService.addDataTransaksiPembayaran(trsPembayaranVoForm);
    }

    @PostMapping("/updateTransaksiPembayaran")
    public DtoResponse updateransaksiPembayaran(@RequestBody PembayaranVoForm trsPembayaranVoForm) {
        return pembayaranService.editDataTransaksiPembayaran(trsPembayaranVoForm);
    }

    @PostMapping("/deleteTransaksiPembayaran")
    public DtoResponse deleteTransaksiPembayaran(@RequestBody PembayaranVoForm trsPembayaranVoForm) {
        return pembayaranService.deleteDataTransaksiPembayaran(trsPembayaranVoForm);
    }
}
