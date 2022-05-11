package hr.tvz.bekavac.hardwareapp.controller;

import hr.tvz.bekavac.hardwareapp.dto.HardwareDTO;
import hr.tvz.bekavac.hardwareapp.dto.ReviewDTO;
import hr.tvz.bekavac.hardwareapp.request.HardwareCommand;
import hr.tvz.bekavac.hardwareapp.request.ReviewCommand;
import hr.tvz.bekavac.hardwareapp.service.interfaces.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    @CrossOrigin(origins = "*")
    public List<ReviewDTO> getAllReviews(){
        return reviewService.findAll();
    }

    /*@GetMapping(value = "{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<ReviewDTO>> getById(@PathVariable Long id){
        return reviewService.findByHardwareId(id).map(reviewDTO -> ResponseEntity.status(HttpStatus.OK).body(reviewDTO))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NO_CONTENT).build());
    }*/

    @GetMapping(value = "/{code}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<ReviewDTO>> getByHardwareCode(@PathVariable String code){
        return reviewService.findByHardwareCode(code).map(reviewDTO -> ResponseEntity.status(HttpStatus.OK).body(reviewDTO))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NO_CONTENT).build());
    }

    @GetMapping(value = "/getReview/{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<ReviewDTO> getReviewById(@PathVariable Long id){
        return reviewService.findReviewById(id).map(reviewDTO -> ResponseEntity.status(HttpStatus.OK).body(reviewDTO))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NO_CONTENT).build());
    }

    @Transactional
    @PostMapping(value = "/addReview")
    @CrossOrigin(origins = "*")
    public ResponseEntity<ReviewDTO> addHardware(@Valid @RequestBody final ReviewCommand request){
        return reviewService.addReview(request).map(reviewDTO -> ResponseEntity.status(HttpStatus.CREATED).body(reviewDTO))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @CrossOrigin(origins = "*")
    @DeleteMapping(value = "/deleteReview/{id}")
    public void deleteHardware(@PathVariable long id){
        reviewService.deleteById(id);
    }
}
