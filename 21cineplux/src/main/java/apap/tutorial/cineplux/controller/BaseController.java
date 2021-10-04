package apap.tutorial.cineplux.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {

    @GetMapping("/")
    private String home(Model model) {
        model.addAttribute("activePage", "home");
        return "home";
    }
}
