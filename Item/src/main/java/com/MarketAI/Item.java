package com.MarketAI;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
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

    @NonNull
    private Long sellerId;

    private Double price;
    private String name;
    private String description;
    private String keyFeatures;
    private String category;
    private Boolean isNew;
    @ElementCollection
    private List<String> photos;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonManagedReference  // Manage the relationship
    private List<Comment> comments; // One-to-many relationship with Comment


}
