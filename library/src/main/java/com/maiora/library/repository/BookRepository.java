package com.maiora.library.repository;

import com.maiora.library.entity.Book;
import com.maiora.library.enums.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByAuthor(String author);

    List<Book> findAllByCategory(BookCategory category);

    Optional<Book> findByIsbn(String ISBN);

    List<Book> findByAuthorIn(List<String> authors);
}

