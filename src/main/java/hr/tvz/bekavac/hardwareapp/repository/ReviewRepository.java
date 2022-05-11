package hr.tvz.bekavac.hardwareapp.repository;

import hr.tvz.bekavac.hardwareapp.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long>, CrudRepository<Review, Long> {

    List<Review> findAll();

    List<Review> findAllByHardware_Id(Long id);

    List<Review> findAllByHardware_Code(String code);

    Optional<Review> findById(Long id);

    void deleteById(Long id);

    Review save(Review review);

}
