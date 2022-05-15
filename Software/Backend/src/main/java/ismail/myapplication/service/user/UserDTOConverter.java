package ismail.myapplication.service.user;

import ismail.myapplication.dto.user.UserDTO;
import ismail.myapplication.repository.entity.user.User;
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
