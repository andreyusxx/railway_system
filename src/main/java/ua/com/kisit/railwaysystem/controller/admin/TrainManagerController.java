package ua.com.kisit.railwaysystem.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.com.kisit.railwaysystem.service.TrainService;

@Controller
@RequestMapping("/admin")
public class TrainManagerController {

    private final TrainService trainService;

    @Autowired
    public TrainManagerController(TrainService trainService) {
        this.trainService = trainService;
    }

    // Відображення сторінки управління (GET)
    @GetMapping("/trains")
    public String getTrainAdmin(Model model) {
        model.addAttribute("allTrains", trainService.getAllTrains());
        return "admin/trains";
    }

    // Збереження нового рейсу (POST)
    @PostMapping("/train/save")
    public String saveNewTrain(@RequestParam String destination,
                               @RequestParam double price,
                               @RequestParam String departureTime) {
        trainService.saveTrain(destination, price, departureTime);
        return "redirect:/admin/trains";
    }

    // Оновлення існуючого рейсу (POST)
    @PostMapping("/train/update")
    public String updateTrain(@RequestParam Long id,
                              @RequestParam String destination,
                              @RequestParam double price,
                              @RequestParam String departureTime,
                              @RequestParam(defaultValue = "false") boolean active) {
        trainService.updateTrain(id, destination, price, departureTime, active);
        return "redirect:/admin/trains";
    }

    // Видалення рейсу (POST)
    @PostMapping("/train/delete")
    public String deleteTrain(@RequestParam Long id) {
        trainService.deleteTrain(id);
        return "redirect:/admin/trains";
    }
}