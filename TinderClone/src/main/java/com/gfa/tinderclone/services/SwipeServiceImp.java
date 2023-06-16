package com.gfa.tinderclone.services;

import com.gfa.tinderclone.models.Swipe;
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

    @Override
    public Swipe createSwipe(Swipe swipe) {
        return swipeRepository.save(swipe);
    }
    @Override
    public Swipe updateSwipe(Swipe swipe) {
        return swipeRepository.save(swipe);
    }
    @Override
    public Swipe getSwipeByUserIds(Long currentUserId, Long otherUserId) {
        return swipeRepository.findByCurrent_user_idAndOther_user_id(currentUserId, otherUserId);
    }
}
