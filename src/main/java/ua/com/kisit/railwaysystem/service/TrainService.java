package ua.com.kisit.railwaysystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.kisit.railwaysystem.entity.Train;
import ua.com.kisit.railwaysystem.repository.TrainRepository;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TrainService {

    private final TrainRepository trainRepository;

    @Autowired
    public TrainService(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    // Збереження нового рейсу
    public void saveTrain(String destination, double price, String departureTime) {
        Train train = new Train();
        train.setDestination(destination);
        train.setPrice(price);
        train.setDepartureTime(LocalDateTime.parse(departureTime));
        train.setActive(true); // Новий рейс активний за замовчуванням

        trainRepository.save(train);
    }

    // Оновлення існуючого рейсу
    public void updateTrain(Long id, String destination, double price, String departureTime, boolean active) {
        Train train = trainRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Рейс не знайдено"));

        train.setDestination(destination);
        train.setPrice(price);
        train.setDepartureTime(LocalDateTime.parse(departureTime));
        train.setActive(active);

        trainRepository.save(train);
    }

    public List<Train> getAllTrains() {
        return trainRepository.findAll();
    }

    public void deleteTrain(Long id) {
        trainRepository.deleteById(id);
    }
}