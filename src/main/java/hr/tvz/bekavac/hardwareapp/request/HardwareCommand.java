package hr.tvz.bekavac.hardwareapp.request;

import hr.tvz.bekavac.hardwareapp.model.Hardware;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Getter
@Setter
@AllArgsConstructor
public class HardwareCommand {

    @NotBlank(message = "Item name must not be empty")
    private String name;

    @NotBlank(message = "Item code must not be empty")
    private String code;

    @PositiveOrZero(message = "Item price must be non-negative")
    private double price;

    @NotNull(message = "Item type must not be empty")
    private Hardware.Type type;

    @PositiveOrZero(message =  "Number of items on storage must be non-negative")
    private int onStorage;

}
