package ismail.myapplication.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class KiteLessonDTO {
    private Long id;
    private String type;
    private Double hours;
    private Integer persons;
    private Double price;
}
