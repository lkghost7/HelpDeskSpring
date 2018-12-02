package by.lk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExecutorController {

    @GetMapping({"/", "/Executor"})
    public String showLoginPage() {
        return "Executor";
    }

}