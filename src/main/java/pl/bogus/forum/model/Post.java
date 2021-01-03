package pl.bogus.forum.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.transaction.annotation.SpringTransactionAnnotationParser;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Post {
    @Id
    private long id;
    private String title;
    private String content;
    private LocalDateTime created;
}
