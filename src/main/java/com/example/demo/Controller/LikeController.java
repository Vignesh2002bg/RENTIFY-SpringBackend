package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.likes;
import com.example.demo.Service.LikeService;
@RestController
@RequestMapping("/api/likes")
public class LikeController {
	@Autowired
    private LikeService likeService;

    @PostMapping("/{propertyId}")
    public ResponseEntity<Void> toggleLike(@RequestParam Long userId, @PathVariable Long propertyId) {
        likeService.toggleLike(userId, propertyId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{propertyId}")
    public ResponseEntity<List<likes>> getLikesByProperty(@PathVariable Long propertyId) {
        List<likes> likes = likeService.getLikesByProperty(propertyId);
        return ResponseEntity.ok(likes);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<likes>> getLikedPropertiesByUser(@PathVariable Long userId) {
        List<likes> likes = likeService.getLikedPropertiesByUser(userId);
        return ResponseEntity.ok(likes);
    }
}

