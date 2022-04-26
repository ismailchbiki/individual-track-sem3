package ismail.myapplication.dto.user;

import lombok.Data;

@Data
public class UserCreateRequest {
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;
}
