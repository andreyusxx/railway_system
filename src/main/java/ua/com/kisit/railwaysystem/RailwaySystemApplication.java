package ua.com.kisit.railwaysystem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ua.com.kisit.railwaysystem.entity.Passenger;
import ua.com.kisit.railwaysystem.entity.Role;
import ua.com.kisit.railwaysystem.entity.Train;
import ua.com.kisit.railwaysystem.entity.User;
import ua.com.kisit.railwaysystem.repository.*;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@EnableCaching
@SpringBootApplication
public class RailwaySystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(RailwaySystemApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CommandLineRunner initManager(UserRepository userRepository,
                                         RoleRepository roleRepository) {
        return args -> {
            // 1. Шукаємо роль ROLE_USER
            Role userRole = roleRepository.findByName("ROLE_USER");

            // Якщо раптом ролі немає в базі - створимо її
            if (userRole == null) {
                userRole = new Role();
                userRole.setName("ROLE_USER");
                roleRepository.save(userRole);
            }

            // 2. Видаляємо старого менеджера, щоб не було конфліктів ID
            User oldManager = userRepository.findByUsername("manager").orElse(null);
            if (oldManager != null) {
                userRepository.delete(oldManager);
            }

            // 3. Створюємо нового менеджера з чистим паролем через Java
            User manager = new User();
            manager.setUsername("manager");
            // Додаємо {bcrypt} перед самим зашифрованим паролем
            manager.setPassword("{bcrypt}" + passwordEncoder().encode("12345"));
            // Використовуємо HashSet для ролей (якщо у тебе Set у сутності User)
            manager.setRoles(new HashSet<>(Collections.singletonList(userRole)));

            userRepository.save(manager);
            System.out.println("✅ Менеджер успішно перезаписаний. Пароль: 12345");
        };
    }
}