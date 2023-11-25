package dave.dev.socialmedia.service;

import dave.dev.socialmedia.model.Like;
import dave.dev.socialmedia.model.Post;
import dave.dev.socialmedia.repository.LikeRepository;
import dave.dev.socialmedia.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LikeService {
    @Autowired
    private LikeRepository likeRepository;
    private PostRepository postRepository;

    public Optional<Like> getLikeById(Long likeId) {
        return likeRepository.findById(likeId);
    }

    public Like addLikeToPost(Long postId, Like like) {
        Optional<Post> postOptional = postRepository.findById(postId);
        postOptional.ifPresent(post -> {
            like.setPost(post);
            post.getLikes().add(like);
            postRepository.save(post);
        });
        return like;
    }

    public void deleteLike(Long likeId) {
        likeRepository.deleteById(likeId);
    }
}
