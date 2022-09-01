package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
// 해당 애너테이션을 적용하면 해당 클래스는 스프링부트의 컨트롤러가 됨
public class MainController {

    @RequestMapping("/sbb") // 요청된 URL과 매핑 담당
    @ResponseBody
    public String index() {
        return "안녕하세요 sbb에 오신 것을 환영합니다.";
    }

    @RequestMapping("/")
    public String root(){
        return "redirect:/question/list";
    }
}

