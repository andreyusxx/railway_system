package ua.com.kisit.railwaysystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisit.railwaysystem.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // Кастомний метод для пошуку користувача за логіном
    Optional<User> findByUsername(String username);
}