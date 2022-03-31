package hr.tvz.bekavac.hardwareapp.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Hardware {

    private String name;
    private String code;
    private double price;
    private Type type;
    private int onStorage;

    public void update(Hardware newHardware) {
        this.code = newHardware.getCode();
        this.name = newHardware.getName();
        this.price = newHardware.getPrice();
        this.type = newHardware.getType();
        this.onStorage = newHardware.getOnStorage();
    }

    public enum Type {CPU, GPU, MBO, RAM, STORAGE, OTHER};
}
