package ismail.individualtrackproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class KiteModel {
    @NotEmpty //Validation
    private String type;
    private Integer hours;
    private Integer people;
    private Double price;
}
