package hr.tvz.bekavac.hardwareapp;

import hr.tvz.bekavac.hardwareapp.controller.AuthenticationController;
import hr.tvz.bekavac.hardwareapp.controller.HardwareController;
import hr.tvz.bekavac.hardwareapp.controller.ReviewController;
import hr.tvz.bekavac.hardwareapp.repository.HardwareRepository;
import hr.tvz.bekavac.hardwareapp.repository.ReviewRepository;
import hr.tvz.bekavac.hardwareapp.repository.UserRepository;
import hr.tvz.bekavac.hardwareapp.service.interfaces.AuthenticationService;
import hr.tvz.bekavac.hardwareapp.service.interfaces.HardwareService;
import hr.tvz.bekavac.hardwareapp.service.interfaces.JwtService;
import hr.tvz.bekavac.hardwareapp.service.interfaces.ReviewService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(classes = HardwareAppApplication.class)
class HardwareAppApplicationTests {

    @Autowired
    HardwareController hardwareController;
    @Autowired
    HardwareService hardwareService;
    @Autowired
    HardwareRepository hardwareRepository;

    @Autowired
    ReviewController reviewController;
    @Autowired
    ReviewService reviewService;
    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    AuthenticationController authenticationController;
    @Autowired
    AuthenticationService authenticationService;
    @Autowired
    JwtService jwtService;
    @Autowired
    UserRepository userRepository;

    @Test
    @Transactional
    void contextLoads() throws Exception{
        hardwareController = new HardwareController(hardwareService);
        reviewController = new ReviewController(reviewService);
        authenticationController = new AuthenticationController(authenticationService);
        assertThat(hardwareController).isNotNull();
        assertThat(reviewController).isNotNull();
        assertThat(authenticationController).isNotNull();
    }

}
