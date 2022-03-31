package ismail.myapplication.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class KiteLessonDTO {
    @NotEmpty //Validation
    private Long id;
    private String type;
    private Double hours;
    private Integer persons;
    private Double price;
}
