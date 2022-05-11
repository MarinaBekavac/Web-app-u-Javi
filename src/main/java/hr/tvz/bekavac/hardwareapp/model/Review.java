package hr.tvz.bekavac.hardwareapp.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "review")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Review implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JoinColumn(name = "hardware_id")
    @ManyToOne()
    private Hardware hardware;

    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private Rating rating;

    public Review(Hardware hardware, String title, String description, Rating rating) {
        this.hardware = hardware;
        this.title = title;
        this.description = description;
        this.rating = rating;
    }

    public enum Rating {one_star, two_stars, three_stars, four_stars, five_stars};

}
