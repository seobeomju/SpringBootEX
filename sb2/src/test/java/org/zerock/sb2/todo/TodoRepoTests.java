package org.zerock.sb2.todo;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.sb2.todo.entities.Todo;
import org.zerock.sb2.todo.repository.TodoRepository;


import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
@Transactional
public class TodoRepoTests {
  
  @Autowired(required = false)
  private TodoRepository repository;


  //gradlew build -x test
  //@Disabled
  @Test
  @Commit
  public void testInsert(){
    //insert는 save( )하시면 끝 
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
  public void testDelete() {

    Long tno = 1L;

    repository.deleteById(tno);

  }

  @Test
  @Commit
  public void testUpdate() {

    java.util.Optional<Todo> result = repository.findById(2L);

    Todo todo = result.get();

    todo.changeTitle("Changed Title 234----1");

  }

  @Test
  public void testList() {

    org.springframework.data.domain.Pageable pageable
     = PageRequest.of(0,10, Sort.by("tno").descending());

    Page<Todo> result = repository.findAll(pageable);

    result.get().forEach(todo -> log.info(todo));

    log.info("---------------");
    log.info(result.getTotalElements());
    log.info(result.getNumber());
    log.info(result.getSize());

  }


  @Test
  public void testQuery1() {

    Pageable pageable = PageRequest.of(0, 10, Sort.by("tno").descending());

    repository.listOfTitle("AAA", pageable);

  }

  @Test
  public void testSelectDTO(){
    log.info(repository.selectDTO(1L));
  }
}