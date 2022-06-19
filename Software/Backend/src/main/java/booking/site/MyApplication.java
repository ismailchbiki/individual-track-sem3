package booking.site;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableAsync
@SpringBootApplication
@Slf4j
public class MyApplication {

    public static void main(String[] args) {
        ApplicationContext appCon = SpringApplication.run(MyApplication.class, args);

        for (String s : appCon.getBeanDefinitionNames()) {
            log.info("Bean: {}", s);
        }
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
