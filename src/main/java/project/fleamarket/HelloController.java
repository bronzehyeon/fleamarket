package project.fleamarket;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("main")
    public String main(Model model) {
        model.addAttribute("data", "hello!!!");
        return "main";
    }
}
