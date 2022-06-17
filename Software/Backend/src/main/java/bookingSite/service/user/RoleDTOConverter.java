package bookingSite.service.user;

import bookingSite.dto.user.RoleDTO;
import bookingSite.repository.entity.user.Role;
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
