package booking.site.user.service;

import booking.site.annotation.Generated;
import booking.site.user.dto.RoleDTO;
import booking.site.user.entity.Role;

@Generated
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