package org.example.todoapp2;

import org.example.todoapp2.dto.TodoDto;
import org.example.todoapp2.repository.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Todoapp2Application {
    public static void main(String[] args) {
        SpringApplication.run(Todoapp2Application.class, args);
    }
    @Bean
    public CommandLineRunner init(TodoRepository todoRepository) {
        return args -> {
//            TodoRepository todoRepository = new TodoRepository();
            todoRepository.save(new TodoDto(null, "study", "JAVA", false));
            todoRepository.save(new TodoDto(null, "cook", "kimbob", false));
            todoRepository.save(new TodoDto(null, "workout", "run", false));

        };
    }
}
