package ismail.myapplication.service.user;

import ismail.myapplication.repository.entity.user.Role;
import ismail.myapplication.repository.entity.user.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
