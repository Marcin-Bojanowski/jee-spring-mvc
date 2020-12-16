package pl.coderslab.controllers;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Controller
@RequestMapping("/first")
public class FormController {
    @GetMapping("/form")
    public String form(){
        return "spring";
    }

    @PostMapping("/form")
    @ResponseBody
    public String editDate(@RequestParam String paramName, @RequestParam @DateTimeFormat(pattern ="yyyy-MM-dd") LocalDate paramDate){
//        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate date=LocalDate.parse(paramDate);
//        String editDate=formatter.format(paramDate);
//        LocalDate newDate=LocalDate.parse(editDate);
        return "name to: "+paramName+" data to: "+paramDate;
    }
}
