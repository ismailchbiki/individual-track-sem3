package ismail.myapplication.repository.entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

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

    @NotNull
    @Column(name = "lesson_type")
    private String type;

    @NotNull
    @Column(name = "duration_per_hours")
    private Double hours;

    @NotNull
    @Column(name = "persons_per_lesson")
    private Integer persons;

    @NotNull
    @Column(name = "lesson_price")
    private Double price;
}