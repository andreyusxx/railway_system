package ua.com.kisit.railwaysystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.kisit.railwaysystem.entity.Train;
import java.util.List;

@Repository
public interface TrainRepository extends JpaRepository<Train, Long> {

    List<Train> findByDestination(String destination);

    List<Train> findByActiveTrue();

    List<Train> findByDestinationAndActiveTrue(String destination);

    List<Train> findByPriceLessThan(Double price);
}