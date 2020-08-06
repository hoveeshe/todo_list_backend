package com.thoughtworks.todolist.service.impl;

import com.thoughtworks.todolist.dao.TodoDao;
import com.thoughtworks.todolist.entity.Todo;
import com.thoughtworks.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoDao todoDao;

    @Override
    public List<Todo> findAll() {
        return this.todoDao.findAll();
    }

    @Override
    @Transactional
    public Todo add(Todo todo) {
        return this.todoDao.save(todo);
    }

    @Override
    @Transactional
    public Todo updateStatusById(Integer id) {
        Todo todo = this.todoDao.getOne(id);
        todo.setStatus(!todo.getStatus());
        return this.todoDao.save(todo);
    }

    @Override
    @Transactional
    public String deleteById(Integer id) {
        this.todoDao.deleteById(id);
        return "delete success";
    }
}
