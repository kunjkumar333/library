package com.maiora.library.dto;

import com.maiora.library.enums.BookCategory;
import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateBookRequest {

    private String title;
    private String author;
    private String isbn;
    private String publishDate;
    private BookCategory category;
}
