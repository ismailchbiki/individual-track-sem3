package ismail.myapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Component
public class KiteLessonDTO {
    @NotEmpty //Validation
    private Long id;
    private String type;
    private Double hours;
    private Integer people;
    private Double price;
}
