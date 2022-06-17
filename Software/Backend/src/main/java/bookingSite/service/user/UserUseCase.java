package bookingSite.service.user;

import bookingSite.dto.user.RoleDTO;
import bookingSite.dto.user.UserDTO;

import java.util.List;

public interface UserUseCase {
    UserDTO saveUser(UserDTO user);

    RoleDTO saveRole(RoleDTO role);

    void addRoleToUser(String username, String roleName);

    UserDTO getUser(String username);

    List<UserDTO> getUsers();
}
