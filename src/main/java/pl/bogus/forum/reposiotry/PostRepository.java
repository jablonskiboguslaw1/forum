package pl.bogus.forum.reposiotry;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.bogus.forum.model.Post;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
    @Query(" Select p from Post p")
    List<Post> findAllPosts(Pageable page);

}
