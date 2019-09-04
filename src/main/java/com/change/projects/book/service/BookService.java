package com.change.projects.book.service;

import java.util.List;

import com.change.projects.book.model.Books;
import com.change.projects.book.repo.BookRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookService{
    @Autowired
    BookRepo repo;

    public List<Books> getAllBooks(){
        return  repo.findAll();
    }

    public void saveBook(Books books){
        repo.save(books);
    }
    public Books getBook(int id){
        return repo.findById(id).get();
    }
    public void delete(int id){
        repo.deleteById(id);
    }

    public List<Books> findBooksByName(String name){
        return repo.findBookByName(name);
    }


}
