package com.gfa.tinderclone.services;

import com.gfa.tinderclone.models.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();
    public void registerUser(User user);
    boolean getUserByEmail(String email);
    boolean getUserByName(String name);
    User getUserById(Long id);

    User getEmptyUser();


}
