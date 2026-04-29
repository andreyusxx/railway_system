package ua.com.kisit.railwaysystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ua.com.kisit.railwaysystem.entity.*;
import ua.com.kisit.railwaysystem.repository.*;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime; // Важливо: додай цей імпорт для дати
import java.util.List;

@Service
public class RailwayService {

    @Autowired
    private TrainRepository trainRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    @Cacheable("trains")
    public List<Train> searchTrainsByDestination(String destination) {
        return trainRepository.findByDestinationAndActiveTrue(destination);
    }

    public List<Train> findAllTrains() {
        return trainRepository.findAll();
    }
    public List<Passenger> findAllPassengers() {
        return passengerRepository.findAll();
    }
    @Transactional
    public void buyTicket(Long trainId, Long passengerId) {
        Train train = trainRepository.findById(trainId)
                .orElseThrow(() -> new RuntimeException("Потяг не знайдено"));

        Passenger passenger = passengerRepository.findById(passengerId)
                .orElseThrow(() -> new RuntimeException("Пасажира не знайдено"));

        Ticket ticket = new Ticket();
        ticket.setTrain(train);
        ticket.setPassenger(passenger);
        ticket.setPurchaseDate(LocalDateTime.now());
        ticketRepository.save(ticket);


        train.setActive(false);
        trainRepository.save(train);
    }

    public List<Train> findAllActiveTrains() {
        return trainRepository.findByActiveTrue(); // Прибрали "Is"
    }

}