package hr.tvz.bekavac.hardwareapp.controller;

import hr.tvz.bekavac.hardwareapp.dto.HardwareDTO;
import hr.tvz.bekavac.hardwareapp.request.HardwareCommand;
import hr.tvz.bekavac.hardwareapp.service.interfaces.HardwareService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping(value = "{code}")
    public ResponseEntity<HardwareDTO> getByCode(@PathVariable String code){
        return hardwareService.findByCode(code).map(hardwareDTO -> ResponseEntity.status(HttpStatus.OK).body(hardwareDTO))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NO_CONTENT).build());
    }

    @PostMapping(value = "/addItem")
    public ResponseEntity<HardwareDTO> addHardware(@Valid @RequestBody final HardwareCommand request){
        return hardwareService.addHardware(request).map(hardwareDTO -> ResponseEntity.status(HttpStatus.CREATED).body(hardwareDTO))
                                            .orElseGet(() -> ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @PutMapping(value = "/editItem/{code}")
    public ResponseEntity<HardwareDTO> updateHardware(@PathVariable String code, @Valid @RequestBody HardwareCommand request){
        return hardwareService.updateHardware(code, request).map(hardwareDTO -> ResponseEntity.status(HttpStatus.CONFLICT).body(hardwareDTO))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NO_CONTENT).build());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/deleteItem/{code}")
    public void deleteHardware(@PathVariable String code){
        hardwareService.deleteByCode(code);
    }

}
