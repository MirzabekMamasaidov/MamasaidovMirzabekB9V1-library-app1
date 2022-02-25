package uz.pdp.mamasaidovmirzabekb9v1libraryapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import uz.pdp.mamasaidovmirzabekb9v1libraryapp.entity.User;

@Controller
public class HomePageController {
    @GetMapping("")
    public String showHomePage(Model model){
        model.addAttribute("user",new User());
        return "index";
    }
}
