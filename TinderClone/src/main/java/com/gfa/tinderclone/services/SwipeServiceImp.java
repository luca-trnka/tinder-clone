package com.gfa.tinderclone.services;

import com.gfa.tinderclone.repositories.SwipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SwipeServiceImp implements SwipeService {

    private final SwipeRepository swipeRepository;

    @Autowired
    public SwipeServiceImp(SwipeRepository swipeRepository) {
        this.swipeRepository = swipeRepository;
    }
}
