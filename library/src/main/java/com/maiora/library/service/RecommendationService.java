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

public interface RecommendationService {

    List<Book> getRecommendations(Long userId, String strategyType);

    void addToReadingList(Long userId, Long bookId);
}



