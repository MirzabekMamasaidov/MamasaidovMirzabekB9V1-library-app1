package uz.pdp.mamasaidovmirzabekb9v1libraryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.mamasaidovmirzabekb9v1libraryapp.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByPhoneNumber(String phoneNumber);
}
