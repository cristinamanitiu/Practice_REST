package com.practice.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cristina.manitiu on 1/12/2018.
 */
@Controller
public class MainHtml {

    @RequestMapping("/mainHtml")
    public String getMainPage(){
        return "main";
    }
}
