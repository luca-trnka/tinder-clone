package com.gfa.tinderclone.services;

import com.gfa.tinderclone.models.Swipe;

public interface SwipeService {
    Swipe createSwipe(Swipe newSwipe);

    Swipe updateSwipe(Swipe swipe);

    Swipe getSwipeByUserIds(Long currentUserId, Long otherUserId);
}
