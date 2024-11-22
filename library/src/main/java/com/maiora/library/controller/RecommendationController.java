package com.maiora.library.controller;


import com.maiora.library.entity.Book;
import com.maiora.library.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {

    @Autowired
    private RecommendationService recommendationService;

    @GetMapping("/user/{userId}")
    public List<Book> getRecommendations(@PathVariable Long userId,
                                         @RequestParam String strategy) {
        return recommendationService.getRecommendations(userId, strategy);
    }


    @PostMapping("/user/addToReadingList")
    public void addToReadingList(@RequestParam Long userId, @RequestParam Long bookId) {
        recommendationService.addToReadingList(userId, bookId);
    }
}
