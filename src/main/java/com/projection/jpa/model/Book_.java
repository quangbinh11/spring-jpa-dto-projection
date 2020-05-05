//package com.projection.jpa.model;
//
//import com.projection.jpa.entities.Author;
//import com.projection.jpa.entities.Book;
//
//import javax.annotation.Generated;
//import javax.persistence.metamodel.SetAttribute;
//import javax.persistence.metamodel.SingularAttribute;
//import javax.persistence.metamodel.StaticMetamodel;
//import java.time.LocalDate;
//
//@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
//@StaticMetamodel(Book.class)
//public abstract class Book_ {
//
//    public static volatile SingularAttribute<Book, Long> id;
//    public static volatile SingularAttribute<Book, String> title;
//    public static volatile SingularAttribute<Book, LocalDate> publishingDate;
//    public static volatile SetAttribute<Book, Author> author;
//    public static volatile SingularAttribute<Book, Double> price;
//    public static volatile SingularAttribute<Author, Integer> version;
//
//}