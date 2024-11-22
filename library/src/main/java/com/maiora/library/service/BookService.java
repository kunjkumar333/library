package com.maiora.library.service;

import com.maiora.library.dto.CreateBookRequest;
import com.maiora.library.dto.UpdateBookRequest;
import com.maiora.library.entity.Book;
import com.maiora.library.enums.BookCategory;

import java.util.List;

public interface BookService {
    Book createBook(CreateBookRequest createBookRequest);

    List<Book> getAllBooks();

    List<Book> getAllBooksByAuthor(String author);

    List<Book> getAllBooksByCategory(BookCategory category);

    String updateBook(UpdateBookRequest updateBookRequest);

    String deleteBook(Long id);
}
