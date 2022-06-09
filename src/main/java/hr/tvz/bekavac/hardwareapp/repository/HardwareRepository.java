package hr.tvz.bekavac.hardwareapp.repository;

import hr.tvz.bekavac.hardwareapp.model.Hardware;
import hr.tvz.bekavac.hardwareapp.request.UpdateOnStorage;

import java.util.List;
import java.util.Optional;

public interface HardwareRepository {

    List<Hardware> findAll();

    Optional<Hardware> findByCode(String code);

    void addHardware(Hardware hardware);

    public Optional<Hardware> addHardwareWithReturnValue(Hardware hardware);

    void deleteByCode(String code);

    void updateHardware(String code, Hardware newHardware);

    Optional<Hardware> updateOnStorage(String code, int onStorage);

    List<Hardware> findByNameLike(String name);

    Optional<Hardware> findById(long id);

    List<Hardware> findAllOnStock();
}
