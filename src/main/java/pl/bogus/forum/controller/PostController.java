package pl.bogus.forum.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import pl.bogus.forum.model.Post;
import pl.bogus.forum.model.dto.PostDto;
import pl.bogus.forum.model.dto.PostDtoMapper;
import pl.bogus.forum.service.PostService;

import java.util.List;



@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;

    @GetMapping("/postsAll")
    public List<Post> getPost(@RequestParam(required = false) Integer page , Sort.Direction sort) {
        int pageNum = ((page != null) && (page >= 0)) ? page : 0;
        Sort.Direction sortDirection = sort!=null ? sort: Sort.Direction.ASC;
        return postService.getPosts(pageNum, sortDirection);

    }

    @GetMapping("/posts/{id}")
    public Post getPostById(@PathVariable long id) {
        return postService.getPostById(id);
    }


    @GetMapping("/post")// this method takes all posts with comments from database and cuts in memory ''/postsAll" mapping provides better method
    public List<PostDto> getPostWithComments(@RequestParam(required = false) Integer page , Sort.Direction sort)  {
        int pageNum = ((page != null) && (page >= 0)) ? page : 0;
        Sort.Direction sortDirection = sort!=null ? sort : Sort.Direction.ASC;
        return PostDtoMapper.mapToPostDtos(postService.getPostsWithComments(pageNum, sortDirection));

    }
   @PostMapping("/posts")
public Post addPost(@RequestBody Post post){
        return postService.addPost(post);
   }
   @PutMapping("/posts")
   public  Post editPost(@RequestBody Post post){
       return postService.editPost(post);

   }
   @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable long id){
        postService.deletePostById(id);
   }


}