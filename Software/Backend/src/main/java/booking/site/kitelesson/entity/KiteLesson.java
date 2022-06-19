package booking.site.kitelesson.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "kite_lesson")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KiteLesson that = (KiteLesson) o;
        return Objects.equals(type, that.type) && Objects.equals(hours, that.hours) && Objects.equals(persons, that.persons) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, hours, persons, price);
    }
}
