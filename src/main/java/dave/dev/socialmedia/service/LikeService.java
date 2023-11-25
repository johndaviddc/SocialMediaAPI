package dave.dev.socialmedia.service;

import dave.dev.socialmedia.model.Like;
import dave.dev.socialmedia.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LikeService {
    @Autowired
    private LikeRepository likeRepository;

    public Optional<Like> getLikeById(Long likeId) {
        return likeRepository.findById(likeId);
    }
}
