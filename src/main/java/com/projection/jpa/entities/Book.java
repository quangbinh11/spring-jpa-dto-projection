package com.projection.jpa.entities;

import java.time.LocalDate;
import javax.persistence.*;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@EqualsAndHashCode
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "publishing_date")
    private LocalDate publishingDate;

    @Column(name = "price")
    private Double price;

    @Column(name = "version")
    private int version;

    @ManyToOne(fetch = FetchType.LAZY)
    private Author author;

    public Book() {
    }

}
