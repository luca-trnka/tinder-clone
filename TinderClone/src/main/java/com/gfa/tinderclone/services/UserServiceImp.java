package com.gfa.tinderclone.services;

import com.gfa.tinderclone.models.User;
import com.gfa.tinderclone.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService{

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void registerUser(User user) {
        userRepository.save(user);
    }

    @Override
    public boolean getUserByEmail(String email) {
        Optional<User> existingUser = userRepository.findUserByEmail(email);
        return existingUser.isPresent();
    }

    @Override
    public boolean getUserByName(String name) {
        Optional<User> existingUser = userRepository.findUserByName(name);
        return existingUser.isPresent();
    }
    @Override
    public User getUserById(Long id) {
        return userRepository.findUserById(id).orElse(null);
    }

    @Override
    public User getEmptyUser() {
        return new User();
    }
}
