package com.projection.jpa.repositories;

import com.projection.jpa.entities.Author;
import com.projection.jpa.entities.dto.BookWithAuthorNames;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT new com.projection.jpa.entities.dto.BookWithAuthorNames(b.id, b.title, b.price, CONCAT(a.firstName, ' ', a.lastName)) FROM Book b JOIN b.author a WHERE b.title LIKE :title")
    public List<BookWithAuthorNames> findBookWithAuthorNames(@Param("title") String title);

    public List<BookWithAuthorNames> findBookWithAuthorNamesByCriteria(@Param("title") String title);
}
