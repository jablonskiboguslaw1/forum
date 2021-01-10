package pl.bogus.forum.service;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.bogus.forum.model.Comment;
import pl.bogus.forum.model.Post;
import pl.bogus.forum.reposiotry.CommentRepository;
import pl.bogus.forum.reposiotry.PostRepository;

import java.util.List;
import java.util.NoSuchElementException;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service

public class PostService {

    public static final int PAGE_SIZE = 20;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Cacheable(cacheNames = "posts")
    public List<Post> getPosts(int page, Sort.Direction sort) {
        List<Post> allPosts = postRepository.findAllPosts(PageRequest.of(page, PAGE_SIZE, Sort.by(sort, "id")));
        List<Long> ids = allPosts.stream()
                .map(Post::getId)
                .collect(Collectors.toList());
        List<Comment> comments = commentRepository.findAllByPostIdIn(ids);
        allPosts.forEach(post -> post.setComment(extractCommentsFromAllComments(comments, post.getId())));
        return allPosts;

    }

    private List<Comment> extractCommentsFromAllComments(List<Comment> comments, long id) {
        return comments.stream()
                .filter(comment -> comment.getPostId() == id)
                .collect(Collectors.toList());
    }

    public List<Post> getPostsWithComments(int page, Sort.Direction sort) {
        return postRepository.findAllPosts(PageRequest.of(page, PAGE_SIZE, Sort.by(sort, "id")));
    }

    @Cacheable(cacheNames = "singlePost", key = "#id")
    public Post getPostById(long id) {

        return postRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public Post addPost(Post post) {
        return postRepository.save(post);
    }


    @Transactional
    @CachePut(cacheNames = "singlePost", key = "#result.id")
    public Post editPost(Post post) {
        Post postById = postRepository.findById(post.getId()).orElseThrow(NoSuchElementException::new);
        postById.setContent(post.getContent());
        postById.setTitle(post.getTitle());
        return postById;

    }

    @CacheEvict(cacheNames = "singlePost")
    public void deletePostById(long id) {
        postRepository.deleteById(id);
    }

    @CacheEvict(cacheNames = "posts")
    public void clearPostWithComments() {

    }


}
