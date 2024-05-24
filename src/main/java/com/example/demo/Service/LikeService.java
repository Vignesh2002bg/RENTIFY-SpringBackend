package com.example.demo.Service;

import com.example.demo.Entity.likes;
import com.example.demo.Repository.LikeRepository;
import com.example.demo.Repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    @Transactional
    public void toggleLike(Long userId, Long propertyId) {
        likes like = likeRepository.findByPropertyIdAndUserId(propertyId, userId);
        if (like != null) {
            likeRepository.delete(like);
            propertyRepository.decrementLikes(propertyId);
        } else {
            likes newLike = new likes();
            newLike.setPropertyId(propertyId);
            newLike.setUserId(userId);
            likeRepository.save(newLike);
            propertyRepository.incrementLikes(propertyId);
        }
    }

    public List<likes> getLikesByProperty(Long propertyId) {
        return likeRepository.findByPropertyId(propertyId);
    }

    public List<likes> getLikedPropertiesByUser(Long userId) {
        return likeRepository.findByUserId(userId);
    }
}
