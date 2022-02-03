package com.jojoldu.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//@EnableJpaAuditing  // JPA Auditing 활성화
@SpringBootApplication  // 스프링 부트의 자동 설정, 스프링 Bean 읽기와 생성 자동으로 설정
public class Application { // 이 프로젝트의 메인 클래스
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        // 내장 WAS 를 실행한다.
    }
}
