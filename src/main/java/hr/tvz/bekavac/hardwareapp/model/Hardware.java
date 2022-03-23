package hr.tvz.bekavac.hardwareapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Hardware {

    private String name;
    private String code;
    private double price;
    private Type type;
    private int onStorage;

    public enum Type {CPU, GPU, MBO, RAM, STORAGE, OTHER};
}
