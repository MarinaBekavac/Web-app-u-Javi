package hr.tvz.bekavac.hardwareapp.service.interfaces;

import hr.tvz.bekavac.hardwareapp.dto.ReviewDTO;
import hr.tvz.bekavac.hardwareapp.model.Review;
import hr.tvz.bekavac.hardwareapp.request.ReviewCommand;

import java.util.List;
import java.util.Optional;

public interface ReviewService {

    List<ReviewDTO> findAll();

    Optional<List<ReviewDTO>> findByHardwareId(Long id);

    Optional<List<ReviewDTO>> findByHardwareCode(String code);

    Optional<ReviewDTO> findReviewById(Long id);

    void deleteById(Long id);

    Optional<ReviewDTO> addReview(ReviewCommand review);

}
