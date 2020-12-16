package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class CookieController {
    @RequestMapping("/setcookie/{value1}/{value2}")
    @ResponseBody
    public String setCookie(HttpServletResponse response,
                            @PathVariable String value1,
                            @PathVariable String value2) {
        Cookie cookie1 = new Cookie("cookie1", value1);
        cookie1.setPath("/");
        response.addCookie(cookie1);

        Cookie cookie2 = new Cookie("cookie2", value2);
        cookie2.setPath("/");
        response.addCookie(cookie2);

        return "dodano ciasteczka";
    }

    @RequestMapping("//getcookies")
    @ResponseBody
    public String getCookies(HttpServletRequest request,
                             @CookieValue("cookie1") String value1) {
        Cookie cookie2 = WebUtils.getCookie(request, "cookie2");

        return "Cookie1: " + value1 + ", Cookie2: " + cookie2.getValue();
    }
}