package ismail.myapplication.repository.entity.user;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

//parent class table
@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
    private String email;
    private String userName;
    private String password;

    //third joining table
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            //@JoinTable creates a third table
            //CascadeType.ALL: whatever happens in the parent table (user),
            //applies to this table as well
            name = "users_roles",
            joinColumns = @JoinColumn(
                    //this third table has a foreign key from user table
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    //this third table has a foreign key from role table
                    name = "role_id", referencedColumnName = "id"
            )
    )
    private Collection<Role> roles;

    public User(String firstName, String lastName, String email, String userName, String password, Collection<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.roles = roles;
    }
}
