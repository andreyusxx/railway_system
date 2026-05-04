package ua.com.kisit.railwaysystem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import ua.com.kisit.railwaysystem.entity.Passenger;
import ua.com.kisit.railwaysystem.entity.Role;
import ua.com.kisit.railwaysystem.entity.Train;
import ua.com.kisit.railwaysystem.entity.User;
import ua.com.kisit.railwaysystem.repository.*;

import java.time.LocalDateTime;
import java.util.Set;

@EnableCaching
@SpringBootApplication
public class RailwaySystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(RailwaySystemApplication.class, args);
    }


}