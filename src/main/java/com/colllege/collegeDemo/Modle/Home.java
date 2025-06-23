package com.colllege.collegeDemo.Modle;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {

    @GetMapping("/welcome")
    public String web(){
        return "Welcome To Web";
    }

}
