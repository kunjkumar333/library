package com.maiora.library.Strategy;
import com.maiora.library.entity.Book;
import java.util.List;

public interface RecommendationStrategy {
    List<Book> recommend(Long userId);
}
