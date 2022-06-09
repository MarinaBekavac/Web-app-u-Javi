package hr.tvz.bekavac.hardwareapp.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "hardware")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Hardware implements Serializable {

    @Column(unique=true)
    private String code;

    @Id
    @Column(name = "id")
    @GeneratedValue
    private long id;

    private String name;

    @Column(name = "on_storage")
    private int onStorage;

    private double price;

    @OneToMany(mappedBy = "hardware", targetEntity = Review.class, fetch=FetchType.EAGER)
    List<Review> reviews;

    @Enumerated(EnumType.STRING)
    private Type type;

    public Hardware(String  code, String name, double price, Type type, int onStorage) {
        this.name = name;
        this.code = code;
        this.price = price;
        this.type = type;
        this.onStorage = onStorage;
    }

    public Hardware(String  code, String name, double price, String type, int onStorage) {
        this.name = name;
        this.code = code;
        this.price = price;
        this.type = Type.valueOf(type);
        this.onStorage = onStorage;
    }

    public Hardware(long id, String  code, String name, double price, Type type, int onStorage) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Hardware ID: " + id + " - Code: " + code + " - Name: " + name + " - Price: " +
                price + " - Type: " + type + " - Stock: " + onStorage;
    }
}
