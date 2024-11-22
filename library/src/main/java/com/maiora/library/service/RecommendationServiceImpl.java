package com.maiora.library.service;

import com.maiora.library.Strategy.RecommendationStrategy;
import com.maiora.library.entity.Book;
import com.maiora.library.entity.ReadingHistory;
import com.maiora.library.entity.ReadingList;
import com.maiora.library.entity.User;
import com.maiora.library.factory.RecommendationStrategyFactory;
import com.maiora.library.repository.ReadingHistoryRepository;
import com.maiora.library.repository.ReadingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationServiceImpl implements RecommendationService{

    @Autowired
    private ReadingHistoryRepository readingHistoryRepository;
    @Autowired
    private ReadingListRepository readingListRepository;

    private final RecommendationStrategyFactory strategyFactory;

    @Autowired
    public RecommendationServiceImpl(RecommendationStrategyFactory strategyFactory) {
        this.strategyFactory = strategyFactory;
    }

    @Override
    public List<Book> getRecommendations(Long userId, String strategyType) {
        RecommendationStrategy strategy = strategyFactory.getStrategy(strategyType);
        return strategy.recommend(userId);
    }

    public void markBookAsRead(Long userId, Long bookId) {
        //mark a book as read for a user
        ReadingHistory readingHistory = new ReadingHistory();
        readingHistory.setUser(new User(userId));
        readingHistory.setBook(new Book(bookId));
        readingHistory.setRead(true);
        readingHistoryRepository.save(readingHistory);
    }

    @Override
    public void addToReadingList(Long userId, Long bookId) {
        // add a book to the users reading list
        ReadingList readingList = new ReadingList();
        readingList.setUser(new User(userId));
        readingList.setBook(new Book(bookId));
        markBookAsRead(userId, bookId);
        readingListRepository.save(readingList);
    }
}
