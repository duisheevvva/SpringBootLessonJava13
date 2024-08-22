package peaksoft.springbootlessonjava13.service;

import peaksoft.springbootlessonjava13.entity.Post;

import java.util.List;

public interface PostService {
    void savePost(Long userId,Post post);
    List<Post>getAllPostByUserId(Long userId);
    Post getPostById(Long postId);
    void updatePost(Long postId,Post newPost);
    void deletePost(Post post);


    Post searchPost(String word);



}
