package booking.site.service.user;

import booking.site.dto.user.UserDTO;
import booking.site.repository.entity.user.User;

public class UserDTOConverter {
    private UserDTOConverter() {
    }

    public static UserDTO convertEntityToDTO(User user) {

        return UserDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .password(user.getPassword()).build();
    }
}
