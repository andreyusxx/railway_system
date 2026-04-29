package ua.com.kisit.railwaysystem.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Train {
    @Column(name = "is_active")
    private Boolean active = true;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String destination;
    private LocalDateTime departureTime;
    private Double price;
}