package com.gfa.tinderclone.services;

import com.gfa.tinderclone.models.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();
    public void registerUser(User user);
    public boolean isExisting(String email);
    public boolean getUserByName(String name);
    public User getUserById(Long id);

    public User getEmptyUser();
    public boolean isSwipeExisting(Long currentUserId, Long otherUserId);


}
