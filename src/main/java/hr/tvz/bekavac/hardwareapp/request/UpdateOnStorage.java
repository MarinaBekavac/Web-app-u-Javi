package hr.tvz.bekavac.hardwareapp.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.PositiveOrZero;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOnStorage{

    @PositiveOrZero(message =  "Number of items on storage must be non-negative")
    private Integer onStorage;

}
