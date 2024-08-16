package com.MarketAI;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

import java.util.List;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String keyFeatures;

    @ElementCollection
    private List<String> photos;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonManagedReference  // Manage the relationship
    private List<Comment> comments; // One-to-many relationship with Comment


}
