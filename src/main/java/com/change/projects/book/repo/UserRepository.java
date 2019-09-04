package com.change.projects.book.repo;

import com.change.projects.book.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);


    @Modifying(clearAutomatically = true)
    @Query(value = "update user set wallet = :amt where username = :username", nativeQuery = true)
    void updateWallet(@Param("amt") String amt, @Param("username") String username);
}
