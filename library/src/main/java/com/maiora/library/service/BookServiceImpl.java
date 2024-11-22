package com.maiora.library.service;

import com.maiora.library.dto.CreateBookRequest;
import com.maiora.library.dto.UpdateBookRequest;
import com.maiora.library.entity.Book;
import com.maiora.library.enums.BookCategory;
import com.maiora.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book createBook(CreateBookRequest createBookRequest) {
        Book book = Book.builder()
                .title(createBookRequest.getTitle())
                .author(createBookRequest.getAuthor())
                .isbn(createBookRequest.getIsbn())
                .publishDate(createBookRequest.getPublishDate())
                .category(createBookRequest.getCategory())
                .build();
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> getAllBooksByAuthor(String author) {
        return bookRepository.findAllByAuthor(author);
    }

    @Override
    public List<Book> getAllBooksByCategory(BookCategory category) {
        return bookRepository.findAllByCategory(category);
    }

    @Override
    public String updateBook(UpdateBookRequest updateBookRequest) {
        Book existingBook = bookRepository.findById(updateBookRequest.getId()).orElse(null);
        if (existingBook == null) {
            return "Book not found";
        }
        existingBook.setTitle(updateBookRequest.getTitle());
        existingBook.setAuthor(updateBookRequest.getAuthor());
        existingBook.setIsbn(updateBookRequest.getIsbn());
        existingBook.setPublishDate(updateBookRequest.getPublishDate());
        existingBook.setCategory(updateBookRequest.getCategory());

        if (!existingBook.getIsbn().equals(updateBookRequest.getIsbn()) &&
                bookRepository.findByIsbn(updateBookRequest.getIsbn()).isPresent()) {
            throw new DataIntegrityViolationException("ISBN must be unique.");
        }
        bookRepository.save(existingBook);
        return "Book updated successfully";
    }

    @Override
    public String deleteBook(Long id) {
        return "Book deleted successfully";
    }
}
