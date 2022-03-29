package ismail.myapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Component
public class KiteLessonDTO {
    @NotEmpty //Validation
    private Long id;
    private String type;
    private Double hours;
    private Integer persons;
    private Double price;
}
