package apap.tutorial.cineplux.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalTime;

@Controller
public class BaseController {

    @GetMapping("/")
    private String home(Model model) {
        LocalTime current = LocalTime.now();
        model.addAttribute("waktuAkses", current);
        model.addAttribute("activePage", "home");
        return "home";
    }
}
