package org.example.todoapp2.controller;

import org.example.todoapp2.dto.TodoDto;
import org.example.todoapp2.repository.TodoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TodoController {
    private final TodoRepository todoRepository = new TodoRepository();

    @GetMapping("/todos")
    public String todos(Model model) {
        List<TodoDto> todo = todoRepository.findAll();
        model.addAttribute("todo", todo);
        return "todos";
    }

    @GetMapping("todos/new")
    public String newTodo() {
        return "new";
    }

    @GetMapping("/todos/create")
    public String create(
            @RequestParam String title,
            @RequestParam String content,
            Model model
    ) {
        TodoDto todoDto = new TodoDto(null, title, content, false);
      //  TodoRepository todoRepository = new TodoRepository();

        TodoDto todo = todoRepository.save(todoDto);
        model.addAttribute("todo", todo);
        // return "create";
        return "redirect:/todos";
    }
}
