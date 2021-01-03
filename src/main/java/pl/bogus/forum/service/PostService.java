package pl.bogus.forum.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.bogus.forum.model.Post;
import pl.bogus.forum.reposiotry.PostRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;


public List<Post> getPosts(){
   return postRepository.findAll();
}


}
