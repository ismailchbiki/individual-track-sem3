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

    /*@Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null, "Ismail Chbiki", "Ismailchbiki", "password", new ArrayList<>()));
            userService.saveUser(new User(null, "Walid Chbiki", "Walidchbiki", "password1", new ArrayList<>()));
            userService.saveUser(new User(null, "Kim Lelie", "Kimlelie", "password2", new ArrayList<>()));
            userService.saveUser(new User(null, "Amal Chbiki", "Amalchbiki", "password3", new ArrayList<>()));

            userService.addRoleToUser("Ismailchbiki", "ROLE_SUPER_ADMIN");
            userService.addRoleToUser("Ismailchbiki", "ROLE_ADMIN");
            userService.addRoleToUser("Ismailchbiki", "ROLE_MANAGER");

            userService.addRoleToUser("Kimlelie", "ROLE_MANAGER");
            userService.addRoleToUser("Kimlelie", "ROLE_ADMIN");

            userService.addRoleToUser("Walidchbiki", "ROLE_USER");
            userService.addRoleToUser("Walidchbiki", "ROLE_ADMIN");

            userService.addRoleToUser("Amalchbiki", "ROLE_USER");
            userService.addRoleToUser("Amalchbiki", "ROLE_MANAGER");
        };
    }*/
}
