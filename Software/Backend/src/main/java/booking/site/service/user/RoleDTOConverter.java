package booking.site.service.user;

import booking.site.dto.user.RoleDTO;
import booking.site.repository.entity.user.Role;

public class RoleDTOConverter {
    private RoleDTOConverter() {
    }

    public static RoleDTO convertEntityToDTO(Role role) {

        return RoleDTO.builder()
                .id(role.getId())
                .name(role.getName())
                .build();
    }
}
