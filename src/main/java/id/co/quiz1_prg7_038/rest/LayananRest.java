package id.co.quiz1_prg7_038.rest;

import id.co.quiz1_prg7_038.model.Layanan;
import id.co.quiz1_prg7_038.repository.LayananRepository;
import id.co.quiz1_prg7_038.response.DtoResponse;
import id.co.quiz1_prg7_038.service.LayananService;
import id.co.quiz1_prg7_038.service.PelangganService;
import id.co.quiz1_prg7_038.vo.LayananVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/layanan")
public class LayananRest {
    @Autowired
    private LayananService layananService;

    @Autowired
    private LayananRepository layananRepository;

    public LayananRest(LayananService layananService) {
        this.layananService = layananService;
    }

    @GetMapping("/getAllDataLayanan")
    public DtoResponse getAllLayanan() {
        return layananService.getAllLayanan();
    }

    @PostMapping("/saveLayanan")
    public DtoResponse createLayanan(@RequestBody LayananVo layananVo) {
        return layananService.addDataLayanan(layananVo);
    }

    // Mengupdate layanan
    @PostMapping("/updateLayanan")
    public DtoResponse updateLayanan(@RequestBody LayananVo layananVo) {
        return layananService.editDataLayanan(layananVo);
    }

    // Menghapus layanan
    @PostMapping("/deleteLayanan")
    public DtoResponse deleteLayanan(@RequestBody LayananVo layananVo) {
        return layananService.deleteDataLayanan(layananVo);
    }

    @GetMapping("/getLayananById")
    public DtoResponse getLayananById(@RequestParam Integer id) {
        Layanan layanan = layananRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Layanan not found"));
        LayananVo layananVo = new LayananVo(layanan);
        return new DtoResponse(200, layananVo, "Data layanan ditemukan");
    }


}
