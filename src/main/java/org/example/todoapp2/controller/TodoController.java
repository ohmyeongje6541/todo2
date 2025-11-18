package org.example.todoapp2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TodoController {

    @GetMapping("/todos")
    public String todos() {
        return "todos";
    }
}
