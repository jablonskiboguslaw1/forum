package pl.bogus.forum.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.bogus.forum.model.Post;
import pl.bogus.forum.reposiotry.PostRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;


    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    public List<Post> getPostsWithComments(){
        return postRepository.findAllPosts(PageRequest.of(0,5));
    }

    public Optional<Post> getPostById(long id) {

        return postRepository.findById(id);
    }
}
