package booking.site.kitelesson.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateKiteLessonResponseDTO {
    private Long kiteLessonId;
}
