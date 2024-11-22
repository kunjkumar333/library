package com.maiora.library.controller;

import com.maiora.library.dto.CreateBookRequest;
import com.maiora.library.dto.UpdateBookRequest;
import com.maiora.library.entity.Book;
import com.maiora.library.enums.BookCategory;
import com.maiora.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/create")
    public Book createBook(@RequestBody CreateBookRequest createBookRequest) {
        return bookService.createBook(createBookRequest);
    }

    @GetMapping("/all")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/author")
    public List<Book> getAllBooksByAuthor(@RequestParam String author) {
        return bookService.getAllBooksByAuthor(author);
    }

    @GetMapping("/category")
    public List<Book> getAllBooksByCategory(@RequestParam String category) {
        return bookService.getAllBooksByCategory(BookCategory.valueOf(category));
    }

    @PutMapping("/update")
    public String updateBook(@RequestBody UpdateBookRequest updateBookRequest) {
       return bookService.updateBook(updateBookRequest);
    }

    @DeleteMapping("/delete/{bookId}")
    public String deleteBook(@PathVariable Long id) {
       return bookService.deleteBook(id);
    }

}
