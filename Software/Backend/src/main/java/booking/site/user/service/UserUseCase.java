package booking.site.user.service;

import booking.site.user.dto.RoleDTO;
import booking.site.user.dto.UserDTO;

import java.util.List;

public interface UserUseCase {
    UserDTO saveUser(UserDTO user);

    RoleDTO saveRole(RoleDTO role);

    void addRoleToUser(String username, String roleName);

    UserDTO getUser(String username);

    List<UserDTO> getUsers();
}
