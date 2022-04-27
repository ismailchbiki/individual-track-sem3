package ismail.myapplication.service.user;

import ismail.myapplication.dto.user.RoleDTO;
import ismail.myapplication.dto.user.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO saveUser(UserDTO user);

    RoleDTO saveRole(RoleDTO role);

    void addRoleToUser(String username, String roleName);

    UserDTO getUser(String username);

    List<UserDTO> getUsers();
}
