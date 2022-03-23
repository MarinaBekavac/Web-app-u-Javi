package hr.tvz.bekavac.hardwareapp.service;

import hr.tvz.bekavac.hardwareapp.dto.HardwareDTO;
import hr.tvz.bekavac.hardwareapp.model.Hardware;
import hr.tvz.bekavac.hardwareapp.repository.HardwareRepository;
import hr.tvz.bekavac.hardwareapp.request.AddHardwareRequest;
import hr.tvz.bekavac.hardwareapp.service.interfaces.HardwareService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HardwareServiceImpl implements HardwareService {

    private final HardwareRepository hardwareRepository;

    public HardwareServiceImpl(HardwareRepository hardwareRepository) {
        this.hardwareRepository = hardwareRepository;
    }


    @Override
    public List<HardwareDTO> findAll() {
        return hardwareRepository.findAll().stream().map(this::mapHardwareToDTO).collect(Collectors.toList());
    }

    private HardwareDTO mapHardwareToDTO(final Hardware hardware){
        return new HardwareDTO(hardware.getName(), hardware.getPrice());
    }

    @Override
    public HardwareDTO findByCode(String code) {
        return hardwareRepository.findByCode(code).map(this::mapHardwareToDTO).orElse(null);
    }

    @Override
    public void addHardware(AddHardwareRequest hardware) {
        hardwareRepository.addHardware(new Hardware(hardware.getName(), hardware.getCode(),
                hardware.getPrice(), hardware.getType(), hardware.getOnStorage()));

    }

    @Override
    public void deleteByCode(String code) {
        hardwareRepository.deleteByCode(code);
    }

}
