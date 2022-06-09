package hr.tvz.bekavac.hardwareapp.repository.impl;

import hr.tvz.bekavac.hardwareapp.model.Hardware;
import hr.tvz.bekavac.hardwareapp.repository.HardwareRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Primary
@Slf4j
@Repository
@Service
public class JDBCHardwareRepositoryImpl implements HardwareRepository {

    private static final String SELECT_ALL = "select * from hardware ";

    private final JdbcTemplate jdbc;
    private final SimpleJdbcInsert inserter;
    private final SimpleJdbcInsert inserterReview;

    public JDBCHardwareRepositoryImpl(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
        this.inserter = new SimpleJdbcInsert(jdbc)
                .withTableName("hardware")
                .usingGeneratedKeyColumns("id");
        this.inserterReview = new SimpleJdbcInsert(jdbc)
                .withTableName("review")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public List<Hardware> findAll() {
        return List.copyOf(jdbc.query(SELECT_ALL, this::mapRowToHardware));
    }

    private Hardware mapRowToHardware(ResultSet rs, int rowNumber) throws SQLException {
            return new Hardware(rs.getLong("id"),
                    rs.getString("code"),
                    rs.getString("name"),
                    rs.getLong("price"),
                    Hardware.Type.valueOf(rs.getString("type")),
                    rs.getInt("on_storage"));

    }

    @Override
    public List<Hardware> findAllOnStock() {
        return List.copyOf(jdbc.query(SELECT_ALL + " where on_storage > 0", this::mapRowToHardware));
    }

    @Override
    public Optional<Hardware> findByCode(String code) {
        try {
            return Optional.ofNullable(jdbc.queryForObject(SELECT_ALL + " where code=?",
                    this::mapRowToHardware, code));
        }catch (EmptyResultDataAccessException ex){
            log.warn("No entry found for code '{}'", code);
            return Optional.empty();
        }
    }

    @Override
    public void addHardware(Hardware hardware) {
        try {
            log.info("Adding hardware 'code:{}-name:{}'", hardware.getCode(), hardware.getName());
            hardware.setId(saveHardwareDetails(hardware));
        }catch (DuplicateKeyException ex){
            hardware = null;
            log.warn("Duplicate key found for hardware '{}' - '{}'", hardware.getCode(), hardware.getName());
        }
    }

    @Override
    public Optional<Hardware> addHardwareWithReturnValue(Hardware hardware) {
        try {
            log.info("Adding hardware 'code:{} - name:{}'", hardware.getCode(), hardware.getName());
            hardware.setId(saveHardwareDetails(hardware));
            return Optional.ofNullable(hardware);
        }catch (DuplicateKeyException ex){
            log.warn("Duplicate key found for hardware '{}' - '{}'", hardware.getCode(), hardware.getName());
            hardware = null;
            return Optional.ofNullable(hardware);
        }
    }

    private long saveHardwareDetails(Hardware hardware) {
        Map<String, Object> values = new HashMap<>();

        values.put("code", hardware.getCode());
        values.put("name", hardware.getName());
        values.put("price", hardware.getPrice());
        values.put("type", hardware.getType());
        values.put("on_Storage", hardware.getOnStorage());

        return inserter.executeAndReturnKey(values).longValue();
    }

    @Override
    public void deleteByCode(String code) {
        jdbc.update("DELETE FROM review WHERE hardware_id in (SELECT id from hardware where code = ?)", code);
        jdbc.update("DELETE FROM hardware WHERE code = ?", code);
    }

    @Override
    public void updateHardware(String code, Hardware newHardware) {
        int executed = jdbc.update("UPDATE hardware SET " +
                "name = ?, " +
                "price = ?, " +
                "type = ?, " +
                "on_storage = ? WHERE code = ?",
                newHardware.getName(),
                newHardware.getPrice(),
                newHardware.getType().toString(),
                newHardware.getOnStorage(),
                code);
    }

    @Override
    public Optional<Hardware> updateOnStorage(String code, int onStorage) {
        //return Optional.empty();
        int executed = jdbc.update("UPDATE hardware SET " +
                        "on_storage = ? WHERE code = ?",
                onStorage,
                code);
        return Optional.ofNullable(findByCode(code).get());
    }

    public List<Hardware> findByNameLike(String name){
        String ps = "SELECT * FROM hardware WHERE LOWER(name) LIKE '%" + name.toLowerCase() +"%'";
        return jdbc.query(ps, this::mapRowToHardware);
    }

    @Override
    public Optional<Hardware> findById(long id) {
        try {
            return Optional.ofNullable(jdbc.queryForObject(SELECT_ALL + " where id=?",
                    this::mapRowToHardware, id));
        }catch (EmptyResultDataAccessException ex){
            log.warn("No entry found for id '{}'", id);
            return Optional.empty();
        }
    }
}
