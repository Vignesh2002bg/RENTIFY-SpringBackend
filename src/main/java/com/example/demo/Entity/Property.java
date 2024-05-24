package com.example.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Property")
public class Property {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String place;
	    private String area;
	    private int bedrooms;
	    private int bathrooms;
	    private String nearbyFacilities;
	    @Column(name = "owner_id") // Specify the column name explicitly
	    private Long ownerId;
	    private int likes;
	    public Property(Long id) {
	        this.id = id;
	    }
	    @ManyToOne
	    @JoinColumn(name = "owner_id", insertable = false, updatable = false) // Specify the column name explicitly
	    private User owner;
}
