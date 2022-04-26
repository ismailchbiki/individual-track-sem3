package ismail.myapplication.service.user;

import ismail.myapplication.dto.user.UserCreateRequest;
import ismail.myapplication.repository.entity.user.User;

public interface UserService {
    User save(UserCreateRequest userCreateRequest);
    public User loadUserByUsername (String username);
}
