package ERP.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("home")
    public String home() {
        return "home/e_home";
    }

    @GetMapping("userhome")
    public String userHome() {
        return "system/Integral_mall";
    }
}
