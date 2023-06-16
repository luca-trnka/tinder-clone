package com.gfa.tinderclone.services;

import com.gfa.tinderclone.models.Direction;
import com.gfa.tinderclone.repositories.DirectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectionServiceImp implements DirectionService {

    private DirectionRepository directionRepository;

    @Autowired
    public DirectionServiceImp(DirectionRepository directionRepository) {
        this.directionRepository = directionRepository;
    }
@Override
    public void save(Direction direction) {
        directionRepository.save(direction);
    }
    @Override
    public List<Direction> getAllDirection() {
        return directionRepository.findAll();
    }
}