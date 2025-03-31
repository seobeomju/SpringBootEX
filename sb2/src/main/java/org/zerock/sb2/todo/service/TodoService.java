package org.zerock.sb2.todo.service;

import org.springframework.transaction.annotation.Transactional;
import org.zerock.sb2.todo.entities.Todo;

@Transactional
public interface TodoService {
    Todo getOne(Long tno);
}
