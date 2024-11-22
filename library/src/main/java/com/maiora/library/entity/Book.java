package com.maiora.library.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.maiora.library.enums.BookCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String author;
    @Pattern(regexp = "\\d{13}", message = "ISBN must be a 13-digit number")
    @Column(unique = true)
    private String isbn;
    @Column(nullable = false)
    private String publishDate;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private BookCategory category;

    public Book(Long id) {
        this.id = id;
    }
}
