package hr.tvz.bekavac.hardwareapp.repository.impl;

import hr.tvz.bekavac.hardwareapp.model.Hardware;
import hr.tvz.bekavac.hardwareapp.repository.HardwareRepository;
import hr.tvz.bekavac.hardwareapp.request.UpdateOnStorage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;

@Slf4j
@Repository
public class HardwareRepositoryImpl implements HardwareRepository {

    private List<Hardware> HARDWARE_IN_STOCK = new ArrayList<>(Arrays.asList(
            new Hardware("CPU", "385-C-P-U", 100.25, Hardware.Type.CPU, 5),
            new Hardware("STORAGE", "385-STORAGE", 500.75, Hardware.Type.STORAGE, 10),
            new Hardware("RAM", "123-RAM-.i89", 320.0, Hardware.Type.RAM, 7))
    );

    @Override
    public List<Hardware> findAllOnStock() {
        return null;
    }

    @Override
    public List<Hardware> findAll() {
        return HARDWARE_IN_STOCK;
    }

    @Override
    public Optional<Hardware> findByCode(String code) {
        log.info("Finding hardware with code '{}' ", code);
        return HARDWARE_IN_STOCK.stream().filter(hardware -> Objects.equals(hardware.getCode(), code)).findAny();
    }

    @Override
    public void addHardware(Hardware hardware) {
        HARDWARE_IN_STOCK.add(hardware);
        log.info("Adding hardware to list");
    }

    @Override
    public Optional<Hardware> addHardwareWithReturnValue(Hardware hardware) {
        return Optional.empty();
    }

    @Override
    public void deleteByCode(String code) {
        Optional<Hardware> hardwareToDelete = HARDWARE_IN_STOCK.stream().filter(hardware -> Objects.equals(hardware.getCode(), code)).findAny();
        if(hardwareToDelete.isPresent())
        {
            HARDWARE_IN_STOCK.remove(hardwareToDelete.get());
            log.info("Deleting hardvare {}", code);
        }else{
            log.info("Hardware item {} doesn't exist to delete", code);
        }
    }

    @Override
    public void updateHardware(String code, Hardware newHardware) {
        HARDWARE_IN_STOCK.stream().filter(hardware -> hardware.getCode().equals(newHardware.getCode())).findFirst().get().update(newHardware);
    }

    @Override
    public Optional<Hardware> updateOnStorage(String code, int onStorage) {
        HARDWARE_IN_STOCK.stream().filter(hardware -> hardware.getCode().equals(code)).findFirst().get().setOnStorage(onStorage);
        return findByCode(code);
    }

    @Override
    public List<Hardware> findByNameLike(String name) {
        return null;
    }

    @Override
    public Optional<Hardware> findById(long id) {
        return Optional.empty();
    }
}
