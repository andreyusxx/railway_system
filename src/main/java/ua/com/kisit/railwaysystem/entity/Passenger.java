package ua.com.kisit.railwaysystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import java.util.List;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "passengers")
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @NotEmpty(message = "Email не може бути порожнім")
    @Email(message = "Некоректний формат Email")
    private String email;

    private String phone;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "passenger")
    private List<Ticket> tickets;

    public String getFullName() {
        return firstName + " " + lastName;
    }
}