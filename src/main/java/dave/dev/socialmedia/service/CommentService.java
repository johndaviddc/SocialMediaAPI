package dave.dev.socialmedia.service;

import dave.dev.socialmedia.model.Comment;
import dave.dev.socialmedia.model.Post;
import dave.dev.socialmedia.repository.CommentRepository;
import dave.dev.socialmedia.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    private PostRepository postRepository;

    public Optional<Comment> getCommentById(Long commentId) {
        return commentRepository.findById(commentId);
    }

    public Comment addCommentToPost(Long postId, Comment comment) {
        Optional<Post> postOptional = postRepository.findById(postId);
        postOptional.ifPresent(post -> {
            comment.setPost(post);
            post.getComments().add(comment);
            postRepository.save(post);
        });

        return comment;
    }
}
