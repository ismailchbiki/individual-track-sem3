package ismail.myapplication.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetAllKiteLessonsResponseDTO {
    private List<KiteLessonDTO> kiteLessons;
}
