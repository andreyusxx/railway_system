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
            // Збереження тестового потяга
            repository.save(new Train(null, "Київ", LocalDateTime.now().plusDays(1), 550.0));
            System.out.println("Тестові дані завантажено успішно!");
        };
    }
}
