package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalTime;

@Controller
public class HelloController {
    @RequestMapping("/hello")
    @ResponseBody
    public String helloWorld() {
        return "Hello body";
    }

    @RequestMapping("/hello/{firstName}/{lastName}")
    @ResponseBody
    public String hello(@PathVariable String firstName, @PathVariable String lastName) {
        return "Witaj " + firstName + " " + lastName;
    }

    @RequestMapping("/helloView")
    public String helloView(Model model) {
        int hour = LocalTime.now().getHour();
       // hour = 23;
        String color = "white";
        String backgroundColor = "black";
        if (hour >= 8 && hour <= 20) {
            color = "black";
            backgroundColor = "white";
        }
        model.addAttribute("color", color);
        model.addAttribute("backgroundColor", backgroundColor);
        return "home";

    }
}