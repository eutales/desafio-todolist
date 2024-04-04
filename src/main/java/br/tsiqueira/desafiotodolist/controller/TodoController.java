package br.tsiqueira.desafiotodolist.controller;

import br.tsiqueira.desafiotodolist.entity.Todo;
import br.tsiqueira.desafiotodolist.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private TodoService todoService;
    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }


    @PostMapping
    List<Todo> create(@RequestBody @Valid Todo todo) {
        return todoService.create(todo);

    }

    @GetMapping
    List<Todo> list() {
        return todoService.list();

    }

    @PutMapping
    List<Todo> update(@RequestBody Todo todo) {
        return todoService.update(todo);
    }

    @DeleteMapping("{id}")
    List<Todo> delete(@PathVariable("id") Long id) {
        return todoService.delete(id);

    }

}
