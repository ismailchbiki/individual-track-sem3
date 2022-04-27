package ismail.myapplication.repository.entity.user;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

//child class table
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String name;
}
