package pl.bogus.forum.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.bogus.forum.model.Post;
import pl.bogus.forum.service.PostService;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;

    @GetMapping("/posts")
    public List<Post> getPost() {
        return postService.getPosts();

    }

    @GetMapping("/posts/{id}")
    public Post getPostById(@PathVariable long id) {
        return postService.getPostById(id).orElseThrow(NoSuchElementException::new);
    }



    @GetMapping("/postsAll")
    public List<Post> getPostWithComments() {
        return postService.getPostsWithComments();

    }}