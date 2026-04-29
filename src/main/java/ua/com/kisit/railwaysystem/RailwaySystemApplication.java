package ua.com.kisit.railwaysystem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import ua.com.kisit.railwaysystem.entity.Passenger;
import ua.com.kisit.railwaysystem.entity.Train;
import ua.com.kisit.railwaysystem.repository.PassengerRepository;
import ua.com.kisit.railwaysystem.repository.TicketRepository;
import ua.com.kisit.railwaysystem.repository.TrainRepository;

import java.time.LocalDateTime;

@EnableCaching
@SpringBootApplication
public class RailwaySystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(RailwaySystemApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(TrainRepository trainRepo, PassengerRepository passengerRepo, TicketRepository ticketRepo) {
        return (args) -> {
            ticketRepo.deleteAll();

            trainRepo.deleteAll();
            trainRepo.save(new Train(true, null, "Київ - Львів", LocalDateTime.now().plusHours(5), 650.0));
            trainRepo.save(new Train(true, null, "Одеса - Харків", LocalDateTime.now().plusHours(12), 820.0));
            trainRepo.save(new Train(true, null, "Дніпро - Ужгород", LocalDateTime.now().plusDays(1), 950.0));
            trainRepo.save(new Train(true, null, "Київ - Івано-Франківськ", LocalDateTime.now().plusHours(8), 450.0));
            trainRepo.save(new Train(true, null, "Миколаїв - Київ", LocalDateTime.now().plusHours(15), 380.0));

            if (passengerRepo.count() == 0) {
                Passenger p = new Passenger();
                p.setFullName("Андрій Шарагін");
                p.setEmail("andrii@mail.com");
                p.setPhone("+380000000000");
                passengerRepo.save(p);
            }

            System.out.println("База даних успішно ініціалізована!");
        };
    }
}