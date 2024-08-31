package com.MarketAI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/")
    public ResponseEntity<Iterable<Comment>> getAllComments() {
        Iterable<Comment> comments = commentService.getAllComments();
        return ResponseEntity.ok(comments);
    }


    @PostMapping
    public ResponseEntity<Comment> createComment(@RequestBody CommentDTO commentDTO) {
        Comment createdComment = commentService.createComment(commentDTO);
        return ResponseEntity.ok(createdComment);
    }
}
