package pl.bogus.forum.reposiotry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bogus.forum.model.Comment;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
    List <Comment> findAllByPostIdIn(List<Long> ids);
}
