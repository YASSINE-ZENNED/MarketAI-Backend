package com.MarketAI;

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
    @GeneratedValue
    private Long id;

    private String name;
    private String description;

    @ElementCollection
    private List<String> photos;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private List<Comment> comments; // Add comments attribute


}
