package hr.tvz.bekavac.hardwareapp.request;

import hr.tvz.bekavac.hardwareapp.model.Hardware;
import hr.tvz.bekavac.hardwareapp.model.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
public class ReviewCommand {

    @NotNull(message = "Item hardware code must not be empty")
    private String hardwareCode;

    @NotBlank(message = "Item title must not be empty")
    private String title;

    @NotBlank(message = "Item description must not be empty")
    private String description;

    @NotNull(message = "Item rating must not be empty")
    private Review.Rating rating;

}
