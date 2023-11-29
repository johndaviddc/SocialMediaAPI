package dave.dev.socialmedia.controller;

import dave.dev.socialmedia.model.Comment;
import dave.dev.socialmedia.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/{commentId}")
    public ResponseEntity<Comment> getCommentById(@PathVariable Long commentId) {
        return commentService.getCommentById(commentId)
                .map(comment -> new ResponseEntity<>(comment, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
