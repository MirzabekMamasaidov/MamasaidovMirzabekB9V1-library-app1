package uz.pdp.mamasaidovmirzabekb9v1libraryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.mamasaidovmirzabekb9v1libraryapp.entity.Book;
import uz.pdp.mamasaidovmirzabekb9v1libraryapp.entity.User;

public interface BookRepository extends JpaRepository<Book,Integer> {
    Integer countById(Integer id);
}
