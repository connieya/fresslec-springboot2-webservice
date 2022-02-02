package com.jojoldu.book.springboot.domain.posts;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity // JPA 의 어노테이션
public class Posts extends BaseTimeEntity {

    @Id // 해당 테이블의 PK 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500 , nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT" , nullable = false)
    private String content;

    private String author;

    @Builder // 빌더 패턴
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title , String content){
        this.title = title;
        this.content = content;














































    }
}
