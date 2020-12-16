package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@Controller
@SessionAttributes("loginStart")
public class SessionController {
    @RequestMapping("/session")
    @ResponseBody
    public String session(HttpSession session, Model model) {
        LocalDateTime loginStart = (LocalDateTime) session.getAttribute("loginStart");
        if (loginStart != null) {
            return loginStart.toString();
        } else {
            model.addAttribute("loginStart", LocalDateTime.now());
            return "Utworzono sesje";
        }
    }
}