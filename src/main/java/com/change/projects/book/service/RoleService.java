package com.change.projects.book.service;

import com.change.projects.book.model.Role;
import com.change.projects.book.repo.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    RoleRepository repository;


    public Role findByName(String name) {
        return repository.findByName(name);
    }
}
