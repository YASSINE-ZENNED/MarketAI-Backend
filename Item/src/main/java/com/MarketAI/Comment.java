package com.MarketAI;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Comment {


    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "itemid")
    private Item item; // Link comment to its item

    private Long clientId;

    private String text;


    @ElementCollection
    private List<String> photos;


}
