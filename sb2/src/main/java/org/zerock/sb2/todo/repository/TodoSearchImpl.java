package org.zerock.sb2.todo.repository;


import java.util.List;


import org.springframework.data.domain.Pageable;
import org.zerock.sb2.todo.entities.Todo;


import com.querydsl.jpa.impl.JPAQueryFactory;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
public class TodoSearchImpl implements TodoSearch{


   private final JPAQueryFactory queryFactory;


  @Override
  public List<Todo> list1(Pageable pageable) {
    log.info("list------------------");
    log.info(queryFactory);

    return null;
  }
 
}
