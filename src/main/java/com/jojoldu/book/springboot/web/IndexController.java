package com.jojoldu.book.springboot.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){

        return "index";
        // 앞에는 src/main/resources/templates가 붙고
        // 뒤에는 .mustache가 붙는다.
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }



}
