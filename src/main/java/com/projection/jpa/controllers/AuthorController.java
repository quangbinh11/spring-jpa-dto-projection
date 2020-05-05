package com.projection.jpa.controllers;

import com.projection.jpa.entities.dto.BookWithAuthorNames;
import com.projection.jpa.repositories.AuthorRepository;
import com.projection.jpa.repositories.AuthorRepositoryImpl;
import com.projection.jpa.repositories.CustomAuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

//    @Autowired
//    private AuthorRepository authorRepository;

    @Autowired
    private CustomAuthorRepository customAuthorRepository;

//    @GetMapping
//    public List<BookWithAuthorNames> findByTitle(@RequestParam(name = "title") String title) {
//        return authorRepository.findBookWithAuthorNames(title);
//    }

    @GetMapping
    public List<BookWithAuthorNames> findByCriteriaTitle(@RequestParam(name = "title") String title) {
        return customAuthorRepository.findBookWithAuthorNamesByCriteria(title);
    }

}
