package hr.tvz.bekavac.hardwareapp.controller;

import hr.tvz.bekavac.hardwareapp.dto.HardwareDTO;
import hr.tvz.bekavac.hardwareapp.dto.ReviewDTO;
import hr.tvz.bekavac.hardwareapp.request.ReviewCommand;
import hr.tvz.bekavac.hardwareapp.service.interfaces.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    @Secured("ROLE_ADMIN")
    @GetMapping(value = "/{code}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<ReviewDTO>> getByHardwareCode(@PathVariable String code){
        return reviewService.findByHardwareCode(code).map(reviewDTO -> ResponseEntity.status(HttpStatus.OK).body(reviewDTO))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NO_CONTENT).build());
    }

    @GetMapping(params = "hardwareCode")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<ReviewDTO>> getByHardwareCodeWithParams(@RequestParam final String hardwareCode){
        return reviewService.findByHardwareCode(hardwareCode).map(reviewDTO -> ResponseEntity.status(HttpStatus.OK).body(reviewDTO))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NO_CONTENT).build());
    }

    @GetMapping(value = "/getReview/{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<ReviewDTO> getReviewById(@PathVariable Long id){
        return reviewService.findReviewById(id).map(reviewDTO -> ResponseEntity.status(HttpStatus.OK).body(reviewDTO))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NO_CONTENT).build());
    }

    @Secured("ROLE_ADMIN")
    @PostMapping(value = "/addReview")
    @CrossOrigin(origins = "*")
    public ResponseEntity<ReviewDTO> addReview(@Valid @RequestBody final ReviewCommand request){
        return reviewService.addReview(request).map(reviewDTO -> ResponseEntity.status(HttpStatus.CREATED).body(reviewDTO))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @Secured({"ROLE_ADMIN", "ROLE_DELETER"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @CrossOrigin(origins = "*")
    @DeleteMapping(value = "/deleteReview/{id}")
    public void deleteReview(@PathVariable long id){
        reviewService.deleteById(id);
    }


    @GetMapping(value = "/labos6/{desc}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<ReviewDTO>> getByDescLike(@PathVariable String desc){
        return reviewService.findAllByDescriptionLike(desc).map(reviewDTO -> ResponseEntity.status(HttpStatus.OK).body(reviewDTO))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NO_CONTENT).build());
    }

    //@Scheduled(cron = "*/10 * * * * *")
    /*public void scheduledJobReview(){
        List<ReviewDTO> listOfReviews = reviewService.findAll();
        if(!listOfReviews.isEmpty()){
            log.info("---------------------------------------------------------------");
            listOfReviews.forEach(reviewDTO -> log.info(reviewDTO.toString()));
            log.info("---------------------------------------------------------------");
        }else{
            log.info("There are no reviews at the moment");
        }
    }*/

    //@Scheduled(cron = "*/10 * * * * *")
    /*public void scheduledJobReviewGetNumberOfReviewsForHardware(){
        List<ReviewDTO> listOfReviews = reviewService.findAll();
        Map<Long, List<ReviewDTO>> numberOfReviewsForHardware = new HashMap<>();
        List<Long> hardwareIds = listOfReviews.stream().map(r -> r.getHardwareId()).collect(Collectors.toList());

        for(Long hardwareId : hardwareIds)
        {
            List<ReviewDTO> reviews = listOfReviews.stream().filter(review -> review.getHardwareId()==hardwareId).collect(Collectors.toList());
            numberOfReviewsForHardware.put(hardwareId, reviews);
        }

        if(!numberOfReviewsForHardware.isEmpty()){
            log.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            logJob(numberOfReviewsForHardware);
            log.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }else{
            log.info("There are no reviews at the moment");
        }
    }

    private void logJob(Map<Long, List<ReviewDTO>> numberOfReviewsForHardware) {
        for(Long key : numberOfReviewsForHardware.keySet()){
            log.info("Hardware: " + key + " Reviews: " + numberOfReviewsForHardware.get(key));
        }
    }*/
}
