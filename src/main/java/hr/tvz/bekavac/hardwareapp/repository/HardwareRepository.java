package hr.tvz.bekavac.hardwareapp.repository;

import hr.tvz.bekavac.hardwareapp.model.Hardware;

import java.util.List;
import java.util.Optional;

public interface HardwareRepository {

    List<Hardware> findAll();

    Optional<Hardware> findByCode(String code);

    void addHardware(Hardware hardware);

    void deleteByCode(String code);
}
