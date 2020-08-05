package com.thoughtworks.todolist.dao;

import com.thoughtworks.todolist.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TodoDao extends JpaRepository<Todo, Integer> {
}
