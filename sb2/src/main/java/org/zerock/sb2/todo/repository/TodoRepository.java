package org.zerock.sb2.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.sb2.todo.entities.Todo;

public interface TodoRepository extends JpaRepository<Todo,Long> {

    
} 