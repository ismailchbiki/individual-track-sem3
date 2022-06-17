package bookingSite.service.user;

import bookingSite.dto.user.UserDTO;
import bookingSite.repository.entity.user.User;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserDTOConverter {
    public static UserDTO convertEntityToDTO(User user) {

        return UserDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .password(user.getPassword()).build();
    }
}
