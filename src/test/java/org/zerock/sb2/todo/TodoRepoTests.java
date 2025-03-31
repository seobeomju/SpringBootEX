package org.zerock.sb2.todo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.sb2.todo.entities.Todo;
import org.zerock.sb2.todo.repository.TodoRepository;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class TodoRepoTests {
    
    @Autowired(required = false)
    private TodoRepository repository;

    @Test
    public void testInsert(){
        //insert는 save()하시면 끝

        Todo todo = Todo.builder()
        .title("Test")
        .writer("user1")
        .build();

        repository.save(todo);
    }
}
