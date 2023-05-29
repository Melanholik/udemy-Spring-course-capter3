package by.melanholik.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "a") Integer a,
                            @RequestParam(value = "b") Integer b,
                            @RequestParam(value = "action") String action,
                            Model model) {
        System.out.println(a + " " + b + " " + action);
        int result;
        String markAction;
        switch (action) {
            case "multiplication" -> {
                result = a * b;
                markAction = "*";
            }
            case "addition" -> {
                result = a + b;
                markAction = "+";
            }
            case "subtraction" -> {
                result = a - b;
                markAction = "-";
            }
            case "division" -> {
                result = a / b;
                markAction = "/";
            }
            default -> throw new IllegalStateException("Unexpected value: " + action);
        }
        model.addAttribute("calcMessage", a + " " + markAction + " " + b + " = " + result);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }
}
