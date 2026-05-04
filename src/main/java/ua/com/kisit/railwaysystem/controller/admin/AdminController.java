package ua.com.kisit.railwaysystem.controller.admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.kisit.railwaysystem.repository.TrainRepository;
import ua.com.kisit.railwaysystem.repository.UserRepository;
import org.springframework.ui.Model;
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private TrainRepository trainRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        // Завантажуємо дані з бази для статистики
        model.addAttribute("trainsCount", trainRepository.count());
        model.addAttribute("usersCount", userRepository.count());

        // Завантажуємо список усіх рейсів
        model.addAttribute("trains", trainRepository.findAll());

        return "admin/dashboard";
    }

}