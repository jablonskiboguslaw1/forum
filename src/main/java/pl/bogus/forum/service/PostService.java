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

    public static final int PAGE_SIZE = 20;
    private final PostRepository postRepository;


    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    public List<Post> getPostsWithComments(int page){
        return postRepository.findAllPosts(PageRequest.of(page, PAGE_SIZE));
    }

    public Optional<Post> getPostById(long id) {

        return postRepository.findById(id);
    }
}
