package ua.com.kisit.railwaysystem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import ua.com.kisit.railwaysystem.entity.Train;
import ua.com.kisit.railwaysystem.repository.TrainRepository;

import java.time.LocalDateTime;
@EnableCaching
@SpringBootApplication
public class RailwaySystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(RailwaySystemApplication.class, args);
    }
    @Bean
    public CommandLineRunner demo(TrainRepository repository) {
        return (args) -> {
            repository.deleteAll(); // Очищаємо, щоб не було дублікатів при перезапуску

            repository.save(new Train(null, "Київ - Львів", LocalDateTime.now().plusHours(5), 650.0));
            repository.save(new Train(null, "Одеса - Харків", LocalDateTime.now().plusHours(12), 820.0));
            repository.save(new Train(null, "Дніпро - Ужгород", LocalDateTime.now().plusDays(1), 950.0));
            repository.save(new Train(null, "Київ - Івано-Франківськ", LocalDateTime.now().plusHours(8), 450.0));
            repository.save(new Train(null, "Миколаїв - Київ", LocalDateTime.now().plusHours(15), 380.0));

            System.out.println("База даних успішно наповнена 5-ма рейсами!");
        };
    }
}
