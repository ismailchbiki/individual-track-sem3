package ismail.myapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateKiteLessonRequestDTO {

    @NotBlank
    @Length(max = 20)
    @Length(min = 2)
    private String type;
    @NotBlank
    @Positive
    private Double hours;
    @NotBlank
    @Positive
    private Integer persons;
    @NotBlank
    @Positive
    private Double price;
}
