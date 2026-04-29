package ua.com.kisit.railwaysystem.controller;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.kisit.railwaysystem.entity.Passenger;
import ua.com.kisit.railwaysystem.entity.Ticket;
import ua.com.kisit.railwaysystem.entity.Train;
import ua.com.kisit.railwaysystem.repository.TrainRepository;
import ua.com.kisit.railwaysystem.service.RailwayService;

import java.util.List;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
public class TrainController {

    @Autowired
    private RailwayService railwayService;

    @GetMapping("/")
    public String index() {
        return "redirect:/trains";
    }

    @GetMapping("/trains")
    public String viewAllTrains(Model model) {
        model.addAttribute("trains", railwayService.findAllActiveTrains());
        return "trains";
    }

    @GetMapping("/search")
    public String search(@RequestParam String dest, Model model) {
        List<Train> result = railwayService.searchTrainsByDestination(dest);
        model.addAttribute("trains", result); // Саме "trains", щоб таблиця оновилася
        model.addAttribute("lastSearch", dest); // Для синього банера зверху
        return "trains";
    }

    @PostMapping("/buy")
    public String buyTicket(@RequestParam Long trainId, RedirectAttributes redirectAttributes) {
        List<Passenger> allPassengers = railwayService.findAllPassengers();

        if (!allPassengers.isEmpty()) {
            Long passengerId = allPassengers.get(0).getId();
            railwayService.buyTicket(trainId, passengerId);

            redirectAttributes.addFlashAttribute("successMessage", "Квиток успішно придбано!");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Помилка: пасажирів не знайдено.");
        }

        return "redirect:/trains";
    }
    @GetMapping("/my-tickets")
    public String viewMyTickets(Model model) {
        List<Passenger> allPassengers = railwayService.findAllPassengers();

        if (!allPassengers.isEmpty()) {
            Long passengerId = allPassengers.get(0).getId();
            List<Ticket> myTickets = railwayService.findTicketsByPassengerId(passengerId);
            model.addAttribute("tickets", myTickets);
            model.addAttribute("passenger", allPassengers.get(0));
        }

        return "my-tickets";
    }

}