package uz.pdp.mamasaidovmirzabekb9v1libraryapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.mamasaidovmirzabekb9v1libraryapp.entity.Book;
import uz.pdp.mamasaidovmirzabekb9v1libraryapp.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> showBooks() {
       return bookRepository.findAll();
    }

    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    public Book get(Integer id) throws UserNotFoundException {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            return optionalBook.get();
        }
        throw  new UserNotFoundException("Not found any books");
    }

    public void delete(Integer id) {
        if (bookRepository.countById(id)>0) {
            bookRepository.deleteById(id);
        }
    }
}
