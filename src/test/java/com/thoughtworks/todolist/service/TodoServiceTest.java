package com.thoughtworks.todolist.service;

import com.thoughtworks.todolist.dao.TodoDao;
import com.thoughtworks.todolist.entity.Todo;
import com.thoughtworks.todolist.service.impl.TodoServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class TodoServiceTest {

    @Mock
    private TodoDao todoDao;

    @InjectMocks
    private TodoServiceImpl todoService;

    @Test
    void should_return_todos_when_get_todos_given_no_parameter() {
        when(todoDao.findAll()).thenReturn(this.getMockTodos());
        List<Todo> todos = this.todoService.findAll();
        assertEquals(5, todos.size());
    }

    private List<Todo> getMockTodos() {
        List<Todo> todos = new ArrayList<>();
        todos.add(new Todo(1, "hovees", false, new Date()));
        todos.add(new Todo(2, "test", true, new Date()));
        todos.add(new Todo(3, "oocl", true, new Date()));
        todos.add(new Todo(4, "thoughtworks", false, new Date()));
        todos.add(new Todo(5, "cargosmart", false, new Date()));
        return todos;
    }

}