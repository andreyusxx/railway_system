package ua.com.kisit.railwaysystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable; // Додай цей імпорт
import org.springframework.stereotype.Service;
import ua.com.kisit.railwaysystem.entity.*;
import ua.com.kisit.railwaysystem.repository.*;
import java.util.List;

@Service
public class RailwayService {

    @Autowired
    private TrainRepository trainRepository;

    @Autowired
    private TicketRepository ticketRepository;
    @Cacheable("trains")
    public List<Train> searchTrainsByDestination(String destination) {
        return trainRepository.findByDestination(destination);
    }

    public Ticket bookTicket(Passenger passenger, Long trainId, String seat) {
        Train train = trainRepository.findById(trainId)
                .orElseThrow(() -> new RuntimeException("Потяг не знайдено"));

        Ticket ticket = new Ticket();
        ticket.setPassenger(passenger);
        ticket.setTrain(train);
        ticket.setSeatNumber(seat);

        return ticketRepository.save(ticket);
    }
    public List<Train> findAllTrains() {
        return trainRepository.findAll();
    }
}