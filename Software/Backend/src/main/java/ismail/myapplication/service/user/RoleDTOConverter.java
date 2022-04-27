package ismail.myapplication.service.user;

import ismail.myapplication.dto.user.RoleDTO;
import ismail.myapplication.repository.entity.user.Role;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RoleDTOConverter {
    public static RoleDTO convertEntityToDTO(Role role) {

        return RoleDTO.builder()
                .id(role.getId())
                .name(role.getName())
                .build();
    }
}
