package ismail.myapplication.repository.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "kite_lesson")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class KiteLesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "lesson_type")
    private String type;

    @Column(name = "duration_per_hours")
    private Double hours;

    @Column(name = "persons_per_lesson")
    private Integer persons;

    @Column(name = "lesson_price")
    private Double price;
}
