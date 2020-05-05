package com.projection.jpa.entities.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookWithAuthorNames {

    private Long bookId;
    private String title;
    private Double price;
    private String authorNames;

    public BookWithAuthorNames(Long bookId, String title, Double price, String authorNames) {
        this.bookId = bookId;
        this.title = title;
        this.price = price;
        this.authorNames = authorNames;
    }
}
