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

    // Отримати всі квитки (для звіту в адмінці)
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    // Знайти квиток за ID
    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Квиток не знайдено"));
    }

    // Видалити квиток (наприклад, при поверненні)
    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }

    // Оновити статус або дані квитка (аналог updateOrder)
    public void updateTicket(Ticket ticket) {
        // Тут можна додати логіку, наприклад, позначити квиток як "Використаний"
        ticketRepository.save(ticket);
    }
}