package com.project.partyMatching.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class homeController {
    @RequestMapping("home")
    public String home() {return "/index";}
}
