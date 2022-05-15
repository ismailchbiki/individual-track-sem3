package ismail.myapplication;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class MyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    CommandLineRunner run(UserService userService) {
//        return args -> {
//            userService.saveRole(new RoleDTO(null, "USER"));
//            userService.saveRole(new RoleDTO(null, "MANAGER"));
//            userService.saveRole(new RoleDTO(null, "MANAGER"));
//            userService.saveRole(new RoleDTO(null, "SUPER_ADMIN"));
//
//            userService.saveUser(new User(null, "Ismail Chbiki", "Ismailchbiki", "password", new ArrayList<>()));
//            userService.saveUser(new User(null, "Max Browne", "max", "password1", new ArrayList<>()));
//            userService.saveUser(new User(null, "Maria Shay", "maria", "password2", new ArrayList<>()));
//            userService.saveUser(new User(null, "Sana Figne", "sana", "password3", new ArrayList<>()));
//
//            userService.addRoleToUser("Ismailchbiki", "ROLE_SUPER_ADMIN");
//            userService.addRoleToUser("Ismailchbiki", "ROLE_ADMIN");
//            userService.addRoleToUser("Ismailchbiki", "ROLE_MANAGER");
//
//            userService.addRoleToUser("someUser", "ROLE_MANAGER");
//            userService.addRoleToUser("someUser", "ROLE_ADMIN");
//
//            userService.addRoleToUser("SomeUser", "ROLE_USER");
//            userService.addRoleToUser("SomeUser", "ROLE_ADMIN");
//
//            userService.addRoleToUser("SomeUser", "ROLE_USER");
//            userService.addRoleToUser("SomeUser", "ROLE_MANAGER");
//        };
//    }
}
