package by.melanholik.springcourse;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    //http://localhost:8080/hello-world
    @GetMapping("/hello-world")
    public String sayHello() {
        System.out.println("2312");
        return "hello_world";
    }
}
