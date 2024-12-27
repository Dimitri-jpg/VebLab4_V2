package mk.ukim.finki.wp.lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication//(scanBasePackages = {"mk.ukim.finki.wp.lab", "mk.ukim.finki.wp.lab"} )
@ServletComponentScan(basePackages = "mk.ukim.finki.wp.lab")
public class SpringBootTest3Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTest3Application.class, args);
    }

    //public SpringBootTest3Application(){}

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }


}
