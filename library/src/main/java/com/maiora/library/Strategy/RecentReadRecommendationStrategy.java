package com.maiora.library.Strategy;

import com.maiora.library.entity.Book;
import com.maiora.library.entity.ReadingHistory;
import com.maiora.library.enums.BookCategory;
import com.maiora.library.repository.BookRepository;
import com.maiora.library.repository.ReadingHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component

public class RecentReadRecommendationStrategy implements RecommendationStrategy {

    @Autowired
    private ReadingHistoryRepository readingHistoryRepository;

    @Autowired
    private BookRepository bookRepository;

    private static final int RECENT_BOOKS_LIMIT = 5;

    @Override
    public List<Book> recommend(Long userId) {
        LocalDateTime current = LocalDateTime.now();
        LocalDateTime past10Days = current.minusDays(10);
        List<ReadingHistory> readingHistory = readingHistoryRepository.findByUser_IdAndReadDateBetween(userId, current, past10Days);
        if (readingHistory.isEmpty()) {
            return bookRepository.findAll();
        }

        // 5 most recent books
        List<ReadingHistory> recentBooks = readingHistory.stream()
                .limit(RECENT_BOOKS_LIMIT)
                .collect(Collectors.toList());

        List<Book> books = new ArrayList<>();
        for (ReadingHistory recentHistory : recentBooks) {
            books.add(recentHistory.getBook());
        }
        return books;
    }
}
