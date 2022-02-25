package uz.pdp.mamasaidovmirzabekb9v1libraryapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.mamasaidovmirzabekb9v1libraryapp.entity.User;
import uz.pdp.mamasaidovmirzabekb9v1libraryapp.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
        public String checkUser(User user) {
            User byPhoneNumber = userRepository.findByPhoneNumber(user.getPhoneNumber());
            if (byPhoneNumber==null||!byPhoneNumber.getPassword().equals(user.getPassword())){
                return "index";
            }
            if (byPhoneNumber.isAdmin()){
                return "redirect:/books";
            }
            else return "index";
        }

}
