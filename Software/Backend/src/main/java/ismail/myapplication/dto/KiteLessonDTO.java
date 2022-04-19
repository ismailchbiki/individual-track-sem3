package ismail.myapplication.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KiteLessonDTO {
    private Long id;
    private String type;
    private Double hours;
    private Integer persons;
    private Double price;
}
