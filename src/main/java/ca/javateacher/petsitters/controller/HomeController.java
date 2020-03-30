package ca.javateacher.petsitters.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = {"/", "/Index", "/Home"})
    public String home(){
        return "Home";
    }
}
