package com.thoughtworks.todolist.service;

import com.thoughtworks.todolist.entity.Todo;

import java.util.List;

public interface TodoService {

    List<Todo> findAll();

    Todo add(Todo todo);

    Todo updateStatusById(Integer id);

    String deleteById(Integer id);

}
