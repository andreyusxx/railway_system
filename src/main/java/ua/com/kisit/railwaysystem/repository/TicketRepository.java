package ua.com.kisit.railwaysystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.kisit.railwaysystem.entity.Ticket;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findByPassengerId(Long passengerId);
    List<Ticket> findByTrainId(Long trainId);
}