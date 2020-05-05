package com.projection.jpa.repositories;

import com.projection.jpa.entities.dto.BookWithAuthorNames;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomAuthorRepository {

    public List<BookWithAuthorNames> findBookWithAuthorNamesByCriteria(@Param("title") String title);
}
