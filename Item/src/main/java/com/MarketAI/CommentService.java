package com.MarketAI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ItemRepository itemRepository;

    public Comment createComment(CommentDTO commentDTO) {
        // Fetch the related Item
        Item item = itemRepository.findById(commentDTO.getItemId())
                .orElseThrow(() -> new RuntimeException("Item not found"));



        // Create a new Comment entity
        Comment comment = new Comment();
        comment.setItem(item);
        comment.setClientId(commentDTO.getClientId());
        comment.setText(commentDTO.getText());
        comment.setPhotos(commentDTO.getPhotos());

        // Save the Comment entity to the database
        return commentRepository.save(comment);
    }

}
