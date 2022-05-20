package hr.tvz.bekavac.hardwareapp.controller;

import hr.tvz.bekavac.hardwareapp.dto.HardwareDTO;
import hr.tvz.bekavac.hardwareapp.request.HardwareCommand;
import hr.tvz.bekavac.hardwareapp.request.UpdateOnStorage;
import hr.tvz.bekavac.hardwareapp.service.interfaces.HardwareService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
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
    @CrossOrigin(origins = "*")
    public List<HardwareDTO> getAllHardware(){
        return hardwareService.findAll();
    }

    @GetMapping(value = "{code}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<HardwareDTO> getByCode(@PathVariable String code){
        return hardwareService.findByCode(code).map(hardwareDTO -> ResponseEntity.status(HttpStatus.OK).body(hardwareDTO))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NO_CONTENT).build());
    }

    @GetMapping(value = "/getById/{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<HardwareDTO> getHardwareById(@PathVariable long id){
        return hardwareService.findById(id).map(hardwareDTO -> ResponseEntity.status(HttpStatus.OK).body(hardwareDTO))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NO_CONTENT).build());
    }


    @Secured({"ROLE_ADMIN", "ROLE_UPDATER"})
    @PostMapping(value = "/addItem")
    @CrossOrigin(origins = "*")
    public ResponseEntity<HardwareDTO> addHardwareDifferentURL(@Valid @RequestBody final HardwareCommand request){
        return hardwareService.addHardware(request).map(hardwareDTO -> ResponseEntity.status(HttpStatus.CREATED).body(hardwareDTO))
                                            .orElseGet(() -> ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @Secured({"ROLE_ADMIN", "ROLE_UPDATER"})
    @PostMapping
    @CrossOrigin(origins = "*")
    public ResponseEntity<HardwareDTO> addHardware(@Valid @RequestBody final HardwareCommand request){
        return hardwareService.addHardware(request).map(hardwareDTO -> ResponseEntity.status(HttpStatus.CREATED).body(hardwareDTO))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @Secured("ROLE_ADMIN")
    @PutMapping(value = "/editItem/{code}")
    public ResponseEntity<HardwareDTO> updateHardwareDifferentURL(@PathVariable String code, @Valid @RequestBody final HardwareCommand request){
        return hardwareService.updateHardware(code, request).map(hardwareDTO -> ResponseEntity.status(HttpStatus.CONFLICT).body(hardwareDTO))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NO_CONTENT).build());
    }

    @Secured("ROLE_ADMIN")
    @PutMapping(value = "/{code}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<HardwareDTO> updateHardware(@PathVariable String code, @Valid @RequestBody final HardwareCommand request){
        return hardwareService.updateHardware(code, request).map(hardwareDTO -> ResponseEntity.status(HttpStatus.CONFLICT).body(hardwareDTO))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NO_CONTENT).build());
    }

    @Secured("ROLE_ADMIN")
    @PatchMapping(value="patchItem/{code}")
    public ResponseEntity<HardwareDTO> updateOnStorage(@PathVariable String code, @Valid @RequestBody final UpdateOnStorage request){
        return hardwareService.updateOnStorage(code, request).map(hardwareDTO -> ResponseEntity.status(HttpStatus.OK).body(hardwareDTO))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NO_CONTENT).build());
    }

    @Secured({"ROLE_ADMIN", "ROLE_DELETER"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @CrossOrigin(origins = "*")
    @DeleteMapping(value = "/deleteItem/{code}")
    public void deleteHardwareDifferentURL(@PathVariable String code){
        hardwareService.deleteByCode(code);
    }

    @Secured({"ROLE_ADMIN", "ROLE_DELETER"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @CrossOrigin(origins = "*")
    @DeleteMapping(value = "/{code}")
    public void deleteHardware(@PathVariable String code){
        hardwareService.deleteByCode(code);
    }

    @GetMapping(value="/lab5/{name}")
    public List<HardwareDTO> getByNameLike(@PathVariable String name){
        return hardwareService.findByNameLike(name);
    }


}
