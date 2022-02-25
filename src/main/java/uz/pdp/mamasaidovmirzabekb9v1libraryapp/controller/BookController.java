package uz.pdp.mamasaidovmirzabekb9v1libraryapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import uz.pdp.mamasaidovmirzabekb9v1libraryapp.entity.Book;
import uz.pdp.mamasaidovmirzabekb9v1libraryapp.service.BookService;
import uz.pdp.mamasaidovmirzabekb9v1libraryapp.service.UserNotFoundException;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public String showBooks(Model model){
        List<Book> bookList = bookService.showBooks();
        model.addAttribute("bookList",bookList);
        return "books";
    }
    @GetMapping("/books/new")
    public String addUser(Model model){
        model.addAttribute("book",new Book());
        model.addAttribute("pageTitle","Add New Book");
        return "book_form";
    }
    @PostMapping("/books/save")
    public String saveBook(Book book, RedirectAttributes ra){
        bookService.saveBook(book);
        ra.addFlashAttribute("message","The book has been saved successfully");
        return "redirect:/books";
    }
    @GetMapping("/books/edit{id}")
    public String showEditForm(@PathVariable Integer id, Model model, RedirectAttributes ra){
        try {
            Book book = bookService.get(id);
            model.addAttribute("book",book);
            model.addAttribute("pageTitle","Edit Book(ID: "+id+")");
            return "book_form";
        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("message","The book has been saved successfully");
            return "redirect:/books";
        }
    }
    @GetMapping("/books/delete{id}")
    public String deleteUser(@PathVariable Integer id){
        bookService.delete(id);
        return "redirect:/books";
    }
}
