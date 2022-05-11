package hr.tvz.bekavac.hardwareapp.service;

import hr.tvz.bekavac.hardwareapp.dto.ReviewDTO;
import hr.tvz.bekavac.hardwareapp.model.Hardware;
import hr.tvz.bekavac.hardwareapp.model.Review;
import hr.tvz.bekavac.hardwareapp.repository.HardwareRepository;
import hr.tvz.bekavac.hardwareapp.repository.ReviewRepository;
import hr.tvz.bekavac.hardwareapp.request.ReviewCommand;
import hr.tvz.bekavac.hardwareapp.service.interfaces.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final HardwareRepository hardwareRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository, HardwareRepository hardwareRepository) {
        this.reviewRepository = reviewRepository;
        this.hardwareRepository = hardwareRepository;
    }

    @Override
    public List<ReviewDTO> findAll() {
        return reviewRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<List<ReviewDTO>> findByHardwareId(Long id) {
        return Optional.ofNullable(reviewRepository.findAllByHardware_Id(id).stream().map(this::mapToDTO).collect(Collectors.toList()));
    }

    @Override
    public Optional<List<ReviewDTO>> findByHardwareCode(String code) {
        return Optional.ofNullable(reviewRepository.findAllByHardware_Code(code).stream().map(this::mapToDTO).collect(Collectors.toList()));
    }

    @Override
    public Optional<ReviewDTO> findReviewById(Long id) {
        return Optional.ofNullable(reviewRepository.findById(id).map(this::mapToDTO).get());
    }

    @Override
    public void deleteById(Long id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public Optional<ReviewDTO> addReview(ReviewCommand review) {
        return Optional.ofNullable(mapToDTO(reviewRepository.save(this.mapCommandToReview(review))));
    }

    private Review mapCommandToReview(ReviewCommand review){
        Optional<Hardware> hardware = hardwareRepository.findByCode(review.getHardwareCode());
        if(!hardware.isPresent()){
            throw new RuntimeException("No hardware found for code '{" + review.getHardwareCode() + "}'");
        }
        return new Review(hardware.get(), review.getTitle(), review.getDescription(), review.getRating());
    }

    private ReviewDTO mapToDTO(Review review){
        return new ReviewDTO(review.getId(), review.getHardware().getId(), review.getTitle(), review.getDescription(), review.getRating());
    }
}
