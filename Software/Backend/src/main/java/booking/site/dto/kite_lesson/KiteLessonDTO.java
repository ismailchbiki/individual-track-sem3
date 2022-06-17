package booking.site.dto.kite_lesson;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
