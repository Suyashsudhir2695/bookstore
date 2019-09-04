package com.change.projects.book.service;

import com.change.projects.book.model.User;


public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
