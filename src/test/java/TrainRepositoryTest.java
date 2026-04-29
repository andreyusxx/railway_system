package ua.com.kisit.railwaysystem;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ua.com.kisit.railwaysystem.repository.TrainRepository;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TrainRepositoryTest {

    @Autowired
    private TrainRepository trainRepository;

    @Test
    void testDatabaseConnection() {
        long count = trainRepository.count();
        assertThat(count).isGreaterThan(0);
    }
}
