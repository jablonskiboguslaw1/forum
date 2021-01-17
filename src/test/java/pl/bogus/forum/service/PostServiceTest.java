package pl.bogus.forum.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import pl.bogus.forum.model.Post;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@WithMockUser
class PostServiceTest {

    @Autowired
    private PostService postService;

    @Test

    void getPostById() {


//given
//when

        Post postById = postService.getPostById(1L);
//then
        assertThat(postById).isNotNull();
        assertThat(postById.getId()).isEqualTo(1L);
        assertThat(postById.getTitle()).isEqualTo("test post1");



    }
}