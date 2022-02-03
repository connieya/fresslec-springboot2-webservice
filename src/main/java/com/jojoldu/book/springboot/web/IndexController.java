package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.config.auth.LoginUser;
import com.jojoldu.book.springboot.config.auth.dto.SessionUser;
import com.jojoldu.book.springboot.service.posts.PostsService;
import com.jojoldu.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/") // 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장할 수 있다.
    public String index(Model model, @LoginUser SessionUser user){
        // postsService.findAllDesc() 로 가져온 결과를 posts 로 index.mustache 에 전달한다.
        model.addAttribute("posts", postsService.findAllDesc());

//        SessionUser user = (SessionUser) httpSession.getAttribute("user");
//            반복되는 코드이기 때문에 @LoginUser 인타페이스 사용
        if(user != null){
            model.addAttribute("userName" ,user.getName());
        }
        return "index";
        // 앞에는 src/main/resources/templates가 붙고
        // 뒤에는 .mustache가 붙는다.
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }


    @GetMapping("/posts/update/{id}") //Model 은  서버 템플릿 엔진에서 사용할 수 있는 객체를 저장할 수 있다.
    public String postsUpdate(@PathVariable Long id , Model model){

        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post",dto);

        return "post_update";
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id){
        postsService.delete(id);

        return id;
    }


}
