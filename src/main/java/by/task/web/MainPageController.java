package by.task.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainPageController {

    @RequestMapping("/first-page")
    public String firstPage() {
        return "first_page";
    }
}
