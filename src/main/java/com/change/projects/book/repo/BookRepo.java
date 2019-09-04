package com.change.projects.book.repo;

import com.change.projects.book.model.Books;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Books, Integer>{
    @Query(value = "select * from books where book_name like %:bookname% or author like %:bookname% or year like %:bookname%", nativeQuery = true)
    List<Books> findBookByName( @Param("bookname") String name);
    
}
