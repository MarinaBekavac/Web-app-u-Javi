package hr.tvz.bekavac.hardwareapp.controller;

import hr.tvz.bekavac.hardwareapp.dto.HardwareDTO;
import hr.tvz.bekavac.hardwareapp.request.AddHardwareRequest;
import hr.tvz.bekavac.hardwareapp.service.interfaces.HardwareService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/hardware")
public class HardwareController {

    private final HardwareService hardwareService;


    public HardwareController(HardwareService hardwareService) {
        this.hardwareService = hardwareService;
    }

    @GetMapping
    public List<HardwareDTO> getAllHardware(){
        return hardwareService.findAll();
    }

    @GetMapping(params = "code")
    public HardwareDTO getByCode(@RequestParam final String code){
        return hardwareService.findByCode(code);
    }

    @PostMapping(value = "/addItem")
    public void addHardware(@RequestBody AddHardwareRequest request){
        hardwareService.addHardware(request);
    }

    @DeleteMapping(value = "/deleteItem/{code}")
    public void deleteHardware(@PathVariable String code){
        hardwareService.deleteByCode(code);
    }

}
