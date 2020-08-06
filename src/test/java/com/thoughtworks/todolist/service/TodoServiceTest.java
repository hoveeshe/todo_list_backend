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
import static org.junit.jupiter.api.Assertions.assertTrue;
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

    @Test
    void should_return_updated_todo_when_update_todo_given_id_and_todo() {
        Integer id = 1;
        Todo todoBefore = this.getMockTodos().get(0);
        Todo todoAfter = this.getMockTodos().get(0);
        todoAfter.setStatus(true);
        when(todoDao.getOne(id)).thenReturn(todoBefore);
        when(todoDao.save(todoBefore)).thenReturn(todoAfter);

        Todo todoUpdated = this.todoService.updateStatusById(id);

        assertTrue(todoUpdated.getStatus());
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