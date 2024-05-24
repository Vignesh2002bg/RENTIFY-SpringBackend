package com.example.demo.dto;

import com.example.demo.Entity.Property;
import com.example.demo.Entity.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LikeRequest {
	private Long userId;
}
