package com.gfa.tinderclone.repositories;

import com.gfa.tinderclone.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    Optional<User> findUserByEmail(String email);
    Optional<User> findUserByName(String name);
    Optional<User> findUserById(Long id);



}
