package com.change.projects.book.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
