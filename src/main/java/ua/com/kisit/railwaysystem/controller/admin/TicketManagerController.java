package ua.com.kisit.railwaysystem.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.com.kisit.railwaysystem.service.TicketService;

@Controller
@RequestMapping("/admin")
public class TicketManagerController {

    private final TicketService ticketService;

    @Autowired
    public TicketManagerController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/tickets")
    public String getAllTickets(Model model) {
        model.addAttribute("tickets", ticketService.getAllTickets());
        return "admin/tickets_manager";
    }

    @PostMapping("/ticket/delete")
    public String deleteTicket(@RequestParam Long id) {
        ticketService.deleteTicket(id);
        return "redirect:/admin/tickets";
    }
}