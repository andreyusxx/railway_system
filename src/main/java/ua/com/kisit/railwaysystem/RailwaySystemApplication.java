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

    @Bean
    public CommandLineRunner demo(TrainRepository trainRepo,
                                  PassengerRepository passengerRepo,
                                  TicketRepository ticketRepo,
                                  RoleRepository roleRepo,
                                  UserRepository userRepo,
                                  PasswordEncoder encoder){
        return (args) -> {
            Role adminRole = roleRepo.findByName("ROLE_ADMIN")
                    .orElseGet(() -> roleRepo.save(new Role("ROLE_ADMIN")));
            roleRepo.findByName("ROLE_USER")
                    .orElseGet(() -> roleRepo.save(new Role("ROLE_USER")));

            if (userRepo.findByUsername("andrii").isEmpty()) {
                User admin = new User();
                admin.setUsername("andrii");
                admin.setPassword(encoder.encode("admin123"));
                admin.setRoles(Set.of(adminRole));
                userRepo.save(admin);

                // 3. Створюємо пасажира для цього користувача
                Passenger p = new Passenger();
                p.setFirstName("Андрій");
                p.setLastName("Шарагін");
                p.setEmail("andrii@mail.com");
                p.setUser(admin);
                passengerRepo.save(p);

                System.out.println("Дані успішно ініціалізовані!");
            }
            ticketRepo.deleteAll();

            trainRepo.deleteAll();
            trainRepo.save(new Train(true, null, "Київ - Львів", LocalDateTime.now().plusHours(5), 650.0));
            trainRepo.save(new Train(true, null, "Одеса - Харків", LocalDateTime.now().plusHours(12), 820.0));
            trainRepo.save(new Train(true, null, "Дніпро - Ужгород", LocalDateTime.now().plusDays(1), 950.0));
            trainRepo.save(new Train(true, null, "Київ - Івано-Франківськ", LocalDateTime.now().plusHours(8), 450.0));
            trainRepo.save(new Train(true, null, "Миколаїв - Київ", LocalDateTime.now().plusHours(15), 380.0));


            System.out.println("База даних успішно ініціалізована!");
        };
    }
}