package com.projection.jpa.repositories;

import com.projection.jpa.entities.Author;
import com.projection.jpa.entities.Author_;
import com.projection.jpa.entities.Book;
import com.projection.jpa.entities.Book_;
import com.projection.jpa.entities.dto.BookWithAuthorNames;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class AuthorRepositoryImpl implements CustomAuthorRepository {

    private EntityManager entityManager;

    public AuthorRepositoryImpl() {
        super();
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-h2-criteria");
        entityManager = factory.createEntityManager();
    }

    @Override
    public List<BookWithAuthorNames> findBookWithAuthorNamesByCriteria(String title) {
        // Create query
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<BookWithAuthorNames> cq = cb.createQuery(BookWithAuthorNames.class);

        // Define FROM clause
        Root<Book> root = cq.from(Book.class);
        Join<Book, Author> author = root.join(Book_.author);

        // Define DTO projection
        cq.select(cb.construct(
                BookWithAuthorNames.class,
                root.get(Book_.id),
                root.get(Book_.title),
                root.get(Book_.price),
                cb.concat(author.get(Author_.firstName), author.get(Author_.lastName))
        ));

        // Define WHERE clause
        ParameterExpression<String> paramTitle = cb.parameter(String.class);
        cq.where(cb.like(root.get(Book_.title), paramTitle));

        // Execute query
        TypedQuery<BookWithAuthorNames> q = entityManager.createQuery(cq);
        q.setParameter(paramTitle, title);
        List<BookWithAuthorNames> books = q.getResultList();

        for (BookWithAuthorNames b : books) {
            System.out.println(b);
        }

        return books;

    }

}
