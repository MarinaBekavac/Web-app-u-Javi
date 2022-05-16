package hr.tvz.bekavac.hardwareapp.dto;

import hr.tvz.bekavac.hardwareapp.model.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ReviewDTO {

    private long id;
    private long hardwareId;
    private String title;
    private String text;
    private Review.Rating rating;

}
