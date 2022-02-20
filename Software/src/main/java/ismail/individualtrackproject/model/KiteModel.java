package ismail.individualtrackproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class KiteModel {
    @NotEmpty
    String type;
    Integer hours;
    Integer people;
    Double price;
}
