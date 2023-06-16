package com.gfa.tinderclone.services;

import com.gfa.tinderclone.models.Direction;

import java.util.List;

public interface DirectionService {
    void save(Direction direction);

    List<Direction> getAllDirection();
}
