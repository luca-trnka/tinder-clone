package com.gfa.tinderclone.repositories;

import com.gfa.tinderclone.models.Swipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SwipeRepository extends JpaRepository<Swipe, Long> {
}
