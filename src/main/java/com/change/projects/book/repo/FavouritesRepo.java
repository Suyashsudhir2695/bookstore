package com.change.projects.book.repo;

import com.change.projects.book.model.Favourites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavouritesRepo extends JpaRepository<Favourites, Long> {
    Favourites findByUserEmailAndName(String email, String name);

    void deleteByUserEmailAndName(String email, String name);

    List<Favourites> findByUserEmail(String email);
}
