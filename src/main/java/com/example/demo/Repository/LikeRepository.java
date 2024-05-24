package com.example.demo.Repository;


import com.example.demo.Entity.likes;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<likes, Long> {
	Optional<likes> findByUserIdAndPropertyId(Long userId, Long propertyId);
    void deleteByUserIdAndPropertyId(Long userId, Long propertyId);
    List<likes> findByPropertyId(Long propertyId);
	List<likes> findByUserId(Long userId);
	 likes findByPropertyIdAndUserId(Long propertyId, Long userId);
    
}
