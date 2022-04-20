package hr.tvz.bekavac.hardwareapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
public class HardwareDTO {

    private String code;
    private String name;
    private double price;

}
