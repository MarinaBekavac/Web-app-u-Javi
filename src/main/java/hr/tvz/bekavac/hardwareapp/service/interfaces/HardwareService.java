package hr.tvz.bekavac.hardwareapp.service.interfaces;

import hr.tvz.bekavac.hardwareapp.dto.HardwareDTO;
import hr.tvz.bekavac.hardwareapp.request.AddHardwareRequest;

import java.util.List;

public interface HardwareService {

    List<HardwareDTO> findAll();

    HardwareDTO findByCode(String code);

    void addHardware(AddHardwareRequest hardware);

    void deleteByCode(String code);
}
