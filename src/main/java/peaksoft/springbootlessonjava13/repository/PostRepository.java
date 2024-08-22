package peaksoft.springbootlessonjava13.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peaksoft.springbootlessonjava13.entity.Post;

import java.util.List;

@Repository
@Transactional
public interface PostRepository extends JpaRepository<Post,Long> {

    @Query("select p from Post p join p.user pu where pu.id = :userId")
    List<Post> getAllPostByUserId(Long userId);

    @Query("select p from Post p where p.title ilike :word")
    Post searchPost(String word);
}
