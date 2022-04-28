package hr.tvz.bekavac.hardwareapp.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Hardware {

    private long id;
    private String code;
    private String name;
    private double price;
    private Type type;
    private int onStorage;

    public Hardware(String code, String name, double price, Type type, int onStorage) {
        this.name = name;
        this.code = code;
        this.price = price;
        this.type = type;
        this.onStorage = onStorage;
    }

    public void update(Hardware newHardware) {
        this.code = newHardware.getCode();
        this.name = newHardware.getName();
        this.price = newHardware.getPrice();
        this.type = newHardware.getType();
        this.onStorage = newHardware.getOnStorage();
    }

    public enum Type {CPU, GPU, MBO, RAM, STORAGE, OTHER};


}
