package com.jojoldu.book.springboot.domain.posts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(
        SpringExtension.class
)// 테스트를 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자를 실행시킴
// 여기서는 SpringExtensipn 이라는 스프링 실행자를 사용함
// 즉, 스프링 부트 테스트와 JUnit 사이에 연결자 역할을 한다.
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @AfterEach // 테스트 메소드가 끝날때마다 수행된다.
    public void cleanup(){
        postsRepository.deleteAll();
    }
    @Test
    public void 게시글저장_불러오기(){
        // given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("jojoldu@gmail.com")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);


    }

    @Test
    public void BaseTimeEntitiy_등록(){
        //given
        LocalDateTime now = LocalDateTime.of(2021,2,28,0,0,0);
        postsRepository.save(Posts.builder()
        .title("title")
        .content("content")
        .author("author")
        .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);

        System.out.println(">>>>>>>> createDate ="+posts.getCreatedDated()
        +", modifiedDate ="+posts.getModifiedDate());

        assertThat(posts.getCreatedDated()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}
