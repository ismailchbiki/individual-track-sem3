package ismail.myapplication.dto.user;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRegistrationDTO {
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;
}
