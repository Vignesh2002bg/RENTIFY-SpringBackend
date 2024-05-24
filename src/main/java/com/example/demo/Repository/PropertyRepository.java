package com.example.demo.Repository;

import com.example.demo.Entity.Property;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface PropertyRepository extends JpaRepository<Property, Long> {

	 List<Property> findByOwnerId(Long ownerId);
    @Modifying
    @Query("UPDATE Property p SET p.likes = p.likes + 1 WHERE p.id = :propertyId")
    void incrementLikes(Long propertyId);

    @Modifying
    @Query("UPDATE Property p SET p.likes = p.likes - 1 WHERE p.id = :propertyId")
    void decrementLikes(Long propertyId);
}
