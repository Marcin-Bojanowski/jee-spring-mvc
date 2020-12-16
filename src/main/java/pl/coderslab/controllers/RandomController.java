package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class RandomController {
    @RequestMapping("/random")
    @ResponseBody
    public String random() {
        Random random = new Random();
        return "Wylosowano liczbę: " + (random.nextInt(100) + 1);
    }

    @RequestMapping("/random/{max}")
    @ResponseBody
    public String randomMax(@PathVariable int max) {
        Random random = new Random();
        int result = random.nextInt(max) + 1;
        return "Użytkownik podał liczbę: " + max + " Wylosowano: " + result;
    }

    @RequestMapping("/random/{min}/{max}")
    @ResponseBody
    public String randomMinMax(@PathVariable int min, @PathVariable int max) {
        Random random = new Random();
        int result = random.nextInt(max - min - 1) + min;
        return "Użytkownik podał zakres od: " + min + " do " + max + " Wylosowano: " + result;
    }


}
