package com.thoughtworks.todolist.controller;

import com.thoughtworks.todolist.entity.Todo;
import com.thoughtworks.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping
    public List<Todo> findAll() {
        return this.todoService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Todo add(@RequestBody Todo todo) {
        return this.todoService.add(todo);
    }

    @PutMapping("/{id}")
    public Todo updateById(@PathVariable Integer id) {
        return this.todoService.updateStatusById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteById(@PathVariable Integer id) {
        return this.todoService.deleteById(id);
    }

}
