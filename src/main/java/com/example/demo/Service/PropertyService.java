package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Property;
import com.example.demo.Entity.User;
import com.example.demo.Entity.likes;
import com.example.demo.Repository.LikeRepository;
import com.example.demo.Repository.PropertyRepository;
import com.example.demo.Repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private LikeRepository likeRepository;
    @Autowired
    private UserRepository userRepository;

    public Property saveProperty(Property property) {
        return propertyRepository.save(property);
    }

    public List<Property> getPropertiesByOwnerId(Long ownerId) {
        return propertyRepository.findByOwnerId(ownerId);
    }

    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

    public void deleteProperty(Long propertyId) {
        propertyRepository.deleteById(propertyId);
    }
    public void incrementLikes(Long id) {
        Optional<Property> property = propertyRepository.findById(id);
        if (property.isPresent()) {
            Property p = property.get();
            p.setLikes(p.getLikes() + 1);
            propertyRepository.save(p);
        } else {
            throw new RuntimeException("Property not found");
        }
    }
    public User getSellerDetails(Long propertyId) {
        Property property = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new RuntimeException("Property not found"));
        return property.getOwner();
    }
   
    
}
