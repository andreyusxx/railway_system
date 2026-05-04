package ua.com.kisit.railwaysystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.kisit.railwaysystem.entity.Ticket;
import ua.com.kisit.railwaysystem.repository.TicketRepository;

import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    // Наприклад, анулювання квитка адміністратором
    public void cancelTicket(Long id) {
        Ticket ticket = ticketRepository.findById(id).orElse(null);
        if (ticket != null) {
            // Тут може бути логіка повернення місця в потяг
            ticketRepository.delete(ticket);
        }
    }
}