package com.maiora.library.Strategy;

import com.maiora.library.entity.Book;
import com.maiora.library.entity.ReadingHistory;
import com.maiora.library.enums.BookCategory;
import com.maiora.library.repository.BookRepository;
import com.maiora.library.repository.ReadingHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AuthorBasedRecommendation implements RecommendationStrategy {

    @Autowired
    private ReadingHistoryRepository readingHistoryRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> recommend(Long userId) {
        LocalDateTime current = LocalDateTime.now();
        LocalDateTime past10Days = current.minusDays(10);
        List<ReadingHistory> readingHistory = readingHistoryRepository.findByUser_IdAndReadDateBetween(userId, current, past10Days);

        if (readingHistory.isEmpty()) {
            return bookRepository.findAll();
        }
        List<String> authors = readingHistory.stream()
                .map(r -> r.getBook().getAuthor())
                .distinct()
                .collect(Collectors.toList());


        return bookRepository.findByAuthorIn(authors);
    }
}
