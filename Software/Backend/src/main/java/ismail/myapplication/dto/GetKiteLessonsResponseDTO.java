package ismail.myapplication.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetKiteLessonsResponseDTO {
    private List<KiteLessonDTO> kiteLessons;
}
