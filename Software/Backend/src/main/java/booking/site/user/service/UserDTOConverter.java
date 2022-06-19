package booking.site.user.service;

import booking.site.annotation.Generated;
import booking.site.user.dto.UserDTO;
import booking.site.user.entity.User;

@Generated
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
