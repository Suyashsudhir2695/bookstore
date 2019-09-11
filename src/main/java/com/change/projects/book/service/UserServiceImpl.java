package com.change.projects.book.service;

import com.change.projects.book.model.Role;
import com.change.projects.book.model.User;
import com.change.projects.book.repo.RoleRepository;
import com.change.projects.book.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<Role>(Arrays.asList(roleRepository.findByName("USER"))));
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Transactional
    public void updateWallet(String amt, String username){
        userRepository.updateWallet(amt, username);
    }

    public int doesUserExist(String username) {
        return userRepository.doesUserExist(username);
    }
}
