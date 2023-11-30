package dave.dev.socialmedia.controller;

import dave.dev.socialmedia.model.Like;
import dave.dev.socialmedia.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/likes")
public class LikeController {
    @Autowired
    private LikeService likeService;

    @GetMapping("/{likeId}")
    public ResponseEntity<Like> getLikeById(@PathVariable Long likeId) {
        return likeService.getLikeById(likeId)
                .map(like -> new ResponseEntity<>(like, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/post/{postId}")
    public ResponseEntity<Like> addLikeToPost(@PathVariable Long postId, @RequestBody Like like) {
        Like addedLike = likeService.addLikeToPost(postId, like);
        return new ResponseEntity<>(addedLike, HttpStatus.CREATED);
    }

    @DeleteMapping("/{likeId}")
    public ResponseEntity<Void> deleteLike(@PathVariable Long likeId) {
        likeService.deleteLike(likeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
