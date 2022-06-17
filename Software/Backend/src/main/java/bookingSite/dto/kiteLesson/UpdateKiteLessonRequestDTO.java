package bookingSite.dto.kiteLesson;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateKiteLessonRequestDTO {

    private Long id;
    @NotEmpty
    @Length(max = 20)
    @Length(min = 2)
    private String type;
    @NotEmpty
    @Positive
    private Double hours;
    @NotEmpty
    @Positive
    private Integer persons;
    @NotEmpty
    @Positive
    private Double price;
}
