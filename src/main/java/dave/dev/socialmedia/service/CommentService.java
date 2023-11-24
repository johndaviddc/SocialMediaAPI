package dave.dev.socialmedia.service;

import dave.dev.socialmedia.model.Comment;
import dave.dev.socialmedia.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public Optional<Comment> getCommentById(Long commentId) {
        return commentRepository.findById(commentId);
    }
}
