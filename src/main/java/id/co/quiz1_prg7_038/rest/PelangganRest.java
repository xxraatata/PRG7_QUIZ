package id.co.quiz1_prg7_038.rest;

import id.co.quiz1_prg7_038.response.DtoResponse;
import id.co.quiz1_prg7_038.service.PelangganService;
import id.co.quiz1_prg7_038.vo.PelangganVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pelanggan")
public class PelangganRest {
    @Autowired
    private PelangganService pelangganService;

    public PelangganRest(PelangganService pelangganService) {
        this.pelangganService = pelangganService;
    }

    @GetMapping("/getAllDataPelanggan")
    public DtoResponse getAllPelanggan() {
        return pelangganService.getAllPelanggan();
    }

    @PostMapping("/savePelanggan")
    public DtoResponse createPelanggan(@RequestBody PelangganVo pelangganVo) {
        return pelangganService.addDataPelanggan(pelangganVo);
    }

    @PostMapping("/updatePelanggan")
    public DtoResponse updatePelanggan(@RequestBody PelangganVo pelangganVo) {
        return pelangganService.editDataPelanggan(pelangganVo);
    }

    @PostMapping("/deletePelanggan")
    public DtoResponse deletePelanggan(@RequestBody PelangganVo pelangganVo) {
        return pelangganService.deleteDataPelanggan(pelangganVo);
    }

}
