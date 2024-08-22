package peaksoft.springbootlessonjava13.service.serviceImpl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.springbootlessonjava13.entity.Post;
import peaksoft.springbootlessonjava13.entity.User;
import peaksoft.springbootlessonjava13.repository.PostRepository;
import peaksoft.springbootlessonjava13.repository.UserRepository;
import peaksoft.springbootlessonjava13.service.PostService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PostServiceImpl implements PostService {

    private final PostRepository postRepo;
    private final UserRepository userRepo;

    @Override
    public void savePost(Long userId, Post post) {
        User user = userRepo.findById(userId).orElseThrow(() ->
                new EntityNotFoundException(String.format("User with id %s not found", userId)));
        post.setUser(user);
        postRepo.save(post);
    }

    @Override
    public List<Post> getAllPostByUserId(Long userId) {
        return postRepo.getAllPostByUserId(userId);
    }

    @Override
    public Post getPostById(Long postId) {
        return postRepo.findById(postId).orElseThrow(()->
                new EntityNotFoundException(String.format("Post with id %s not found",postId)));
    }

    @Override
    public void updatePost(Long postId, Post newPost) {
       Post post = getPostById(postId);
       post.setTitle(newPost.getTitle());
       post.setDescription(newPost.getDescription());
       post.setImage(newPost.getImage());
    }

    @Override
    public void deletePost(Post post) {
        postRepo.delete(post);

    }

    @Override
    public Post searchPost(String word) {
        return postRepo.searchPost(word);
    }
}
