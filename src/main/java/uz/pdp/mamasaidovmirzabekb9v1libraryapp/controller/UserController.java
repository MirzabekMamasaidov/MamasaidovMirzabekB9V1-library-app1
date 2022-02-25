package uz.pdp.mamasaidovmirzabekb9v1libraryapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import uz.pdp.mamasaidovmirzabekb9v1libraryapp.entity.User;
import uz.pdp.mamasaidovmirzabekb9v1libraryapp.service.UserService;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/users/enter")
    public String checkUser(Model model, User user){
        return  userService.checkUser(user);
    }

}
