package aw.krauterkiste.logIn.controller;


import aw.krauterkiste.logIn.service.LoginService;
import aw.krauterkiste.logIn.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class LoginController {

    private final LoginService loginService;

    @Autowired // @Lazy ist eingefügt um circular dependencies aufzulösen
    public LoginController(@Lazy LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping(value = "/")
    public String homepage(Model model) {
        model.addAttribute("user", new UserDto());
        return "index";
    }

    @PostMapping(value = "/loginUser")
    public String loginUser(Model model) {

        return "redirect:/?";
    }

    @GetMapping(value = "/logOutUser")
    public String loginUser(){
        SecurityContextHolder.getContext().setAuthentication(null);
        return "redirect:/";
    }
}
