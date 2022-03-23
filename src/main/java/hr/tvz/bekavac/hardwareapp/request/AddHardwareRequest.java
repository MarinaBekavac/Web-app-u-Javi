package hr.tvz.bekavac.hardwareapp.request;

import hr.tvz.bekavac.hardwareapp.model.Hardware;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AddHardwareRequest {

    private String name;
    private String code;
    private double price;
    private Hardware.Type type;
    private int onStorage;

}
