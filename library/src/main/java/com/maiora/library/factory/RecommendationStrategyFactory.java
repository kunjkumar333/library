package com.maiora.library.factory;

import com.maiora.library.Strategy.AuthorBasedRecommendation;
import com.maiora.library.Strategy.RecentReadRecommendationStrategy;
import com.maiora.library.Strategy.RecommendationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RecommendationStrategyFactory {

    // Autowire the strategy beans
    @Autowired
    private RecentReadRecommendationStrategy recentReadRecommendationStrategy;

    @Autowired
    private AuthorBasedRecommendation authorBasedRecommendation;

    public RecommendationStrategy getStrategy(String strategyType) {
        switch (strategyType.toLowerCase()) {
            case "recent-read":
                return recentReadRecommendationStrategy;  // Return the injected bean
            case "author-based":
                return authorBasedRecommendation;  // Return the injected bean
            default:
                throw new IllegalArgumentException("Invalid recommendation strategy");
        }
    }
}
