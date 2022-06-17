package booking.site.service.user;

import booking.site.dto.user.RoleDTO;
import booking.site.dto.user.UserDTO;

import java.util.List;

public interface UserUseCase {
    UserDTO saveUser(UserDTO user);

    RoleDTO saveRole(RoleDTO role);

    void addRoleToUser(String username, String roleName);

    UserDTO getUser(String username);

    List<UserDTO> getUsers();
}
