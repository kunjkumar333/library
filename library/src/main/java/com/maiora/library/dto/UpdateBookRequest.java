package com.maiora.library.dto;

import com.maiora.library.enums.BookCategory;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UpdateBookRequest {
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private String publishDate;
    private BookCategory category;
}
