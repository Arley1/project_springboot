package dev.com.servlet;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HellloWord {
    @RequestMapping("/hello")
    String Hello()
    {
        return "hello";
    }
}
