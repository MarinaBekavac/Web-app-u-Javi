package hr.tvz.bekavac.hardwareapp.service.interfaces;

import hr.tvz.bekavac.hardwareapp.dto.HardwareDTO;
import hr.tvz.bekavac.hardwareapp.model.Review;
import hr.tvz.bekavac.hardwareapp.request.HardwareCommand;
import hr.tvz.bekavac.hardwareapp.request.UpdateOnStorage;

import java.util.List;
import java.util.Optional;

public interface HardwareService {

    List<HardwareDTO> findAll();

    Optional<HardwareDTO> findByCode(String code);

    Optional<HardwareDTO> addHardware(HardwareCommand hardware);

    void deleteByCode(String code);

    Optional<HardwareDTO> updateHardware(String code, HardwareCommand request);

    Optional<HardwareDTO> updateOnStorage(String code, UpdateOnStorage request);

    public List<HardwareDTO> findByNameLike(String name);

    Optional<HardwareDTO> findById(long id);
}
