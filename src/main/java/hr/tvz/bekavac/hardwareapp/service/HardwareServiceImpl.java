package hr.tvz.bekavac.hardwareapp.service;

import hr.tvz.bekavac.hardwareapp.dto.HardwareDTO;
import hr.tvz.bekavac.hardwareapp.model.Hardware;
import hr.tvz.bekavac.hardwareapp.repository.HardwareRepository;
import hr.tvz.bekavac.hardwareapp.request.HardwareCommand;
import hr.tvz.bekavac.hardwareapp.request.UpdateOnStorage;
import hr.tvz.bekavac.hardwareapp.service.interfaces.HardwareService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
        return new HardwareDTO(hardware.getCode(), hardware.getName(), hardware.getPrice());
    }

    private Hardware mapCommandToHardware(HardwareCommand hardwareCommand){
        return new Hardware().builder().code(hardwareCommand.getCode()).name(hardwareCommand.getName()).type(hardwareCommand.getType())
                .price(hardwareCommand.getPrice()).onStorage(hardwareCommand.getOnStorage()).build();
    }

    private HardwareDTO mapCommandToDTO(HardwareCommand request) {
        return new HardwareDTO(request.getCode(), request.getName(), request.getPrice());
    }

    @Override
    public Optional<HardwareDTO> findByCode(String code) {
        return Optional.ofNullable(hardwareRepository.findByCode(code).map(this::mapHardwareToDTO).orElse(null));
    }

    @Override
    public Optional<HardwareDTO> addHardware(HardwareCommand hardware) {
        Hardware newHardware = new Hardware(hardware.getCode(), hardware.getName(),
                hardware.getPrice(), hardware.getType(), hardware.getOnStorage());

        hardwareRepository.addHardware(newHardware);
        return Optional.ofNullable(mapHardwareToDTO(newHardware));
    }

    @Override
    public void deleteByCode(String code) {
        hardwareRepository.deleteByCode(code);
    }

    @Override
    public Optional<HardwareDTO> updateHardware(String code, HardwareCommand request) {
        hardwareRepository.updateHardware(code, mapCommandToHardware(request));
        return Optional.ofNullable(mapCommandToDTO(request));
    }

    @Override
    public Optional<HardwareDTO> updateOnStorage(String code, UpdateOnStorage request) {
        HardwareDTO newHardwareDto = mapHardwareToDTO(hardwareRepository.updateOnStorage(code, request.getOnStorage()).get());
        return Optional.ofNullable(newHardwareDto);
    }
}
