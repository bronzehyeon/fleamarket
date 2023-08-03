package project.fleamarket.Member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

    @GetMapping(value = "/user/login")
    public String login(Model model) {
        model.addAttribute("data", "/user/login");
        return "login";
    }

    @GetMapping(value = "/user/signup")
    public String signup(Model model) {
        model.addAttribute("data", "/user/signup");
        return "signup";
    }
}
