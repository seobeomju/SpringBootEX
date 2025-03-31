package org.zerock.sb2.todo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.zerock.sb2.todo.entities.Todo;
import org.zerock.sb2.todo.repository.TodoRepository;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
@Transactional
public class TodoRepoTests {
    
    @Autowired(required = false)
    private TodoRepository repository;

    // @Disabled
    @Test
    public void testInsert(){
        //insert는 save()하시면 끝

        Todo todo = Todo.builder()
        .title("Test")
        .writer("user1")
        .build();

        repository.save(todo);
    }
    @Test
    public void testRead(){
        java.util.Optional<Todo> result = repository.findById(1L);

        log.info(result.get());
    }

    @Test
    public void testDelete(){
        Long tno = 1L;
        repository.deleteById(tno);
    }

    @Test
    @Commit
    public void testUpdate(){
        java.util.Optional<Todo> result = repository.findById(2L);
        Todo todo = result.get();
        todo.changeTitle("change Title 234");

    }
}
