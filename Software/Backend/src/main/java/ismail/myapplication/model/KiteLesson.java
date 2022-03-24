package ismail.myapplication.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Component
public class KiteLesson {
    @NotEmpty //Validation
    private String type;
    private Integer hours;
    private Integer people;
    private Double price;
}
