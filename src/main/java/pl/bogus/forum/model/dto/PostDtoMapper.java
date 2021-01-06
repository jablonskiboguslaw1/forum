package pl.bogus.forum.model.dto;

import pl.bogus.forum.model.Post;

import java.util.List;
import java.util.stream.Collectors;

public class PostDtoMapper {

    private PostDtoMapper() {
    }

    public static List<PostDto> mapToPostDtos(List<Post> postsWithComments) {

        return postsWithComments.stream().map(post -> mapToPostDto(post)).collect(Collectors.toList());
    }

    private static PostDto mapToPostDto(Post post) {
        return PostDto.builder()
                .id(post.getId())
                .content(post.getContent())
                .title(post.getTitle())
                .created(post.getCreated())
                .build();
    }
}
