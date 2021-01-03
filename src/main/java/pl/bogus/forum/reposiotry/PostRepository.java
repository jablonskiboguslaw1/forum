package pl.bogus.forum.reposiotry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bogus.forum.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
}
