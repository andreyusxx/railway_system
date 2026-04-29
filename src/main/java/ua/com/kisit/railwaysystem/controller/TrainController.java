package ua.com.kisit.railwaysystem.controller;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.kisit.railwaysystem.repository.TrainRepository;
import ua.com.kisit.railwaysystem.service.RailwayService;

@Controller
public class TrainController {

    @Autowired
    private RailwayService railwayService;

    @GetMapping("/search")
    public String search(@RequestParam String dest, Model model, HttpSession session) {
        session.setAttribute("lastSearch", dest);

        model.addAttribute("trains", railwayService.searchTrainsByDestination(dest));
        return "trains";
    }
}