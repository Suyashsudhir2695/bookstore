package com.change.projects.book.service;

import com.change.projects.book.model.Favourites;
import com.change.projects.book.repo.FavouritesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavouritesService {
    @Autowired
    FavouritesRepo repo;

    public Favourites findByUserEmailAndName(String email, String name) {
        return repo.findByUserEmailAndName(email, name);
    }

    public void deleteByEmailAndName(String email, String name) {
        repo.deleteByUserEmailAndName(email, name);
        System.out.println("Deleted " + name);
    }

    public List<Favourites> findByUserEmail(String email) {
        return repo.findByUserEmail(email);
    }

    public void saveFavs(Favourites favourites) {
        repo.save(favourites);
    }


}
