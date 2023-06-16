package com.gfa.tinderclone.repositories;

import com.gfa.tinderclone.models.Direction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DirectionRepository extends JpaRepository<Direction, Long> {

    @Override
    List<Direction> findAll();
}
