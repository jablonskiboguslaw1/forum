package pl.bogus.forum.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;;
@RequiredArgsConstructor
@Configuration
public class Config {

    private final ObjectMapper objectMapper;

void customizeObjectMapper(){
    objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
}
}
