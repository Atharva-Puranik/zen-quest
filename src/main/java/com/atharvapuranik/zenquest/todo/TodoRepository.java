package com.atharvapuranik.zenquest.todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TodoRepository extends JpaRepository<ToDo, Integer> {
    public List<ToDo> findByUsername(String username);
}