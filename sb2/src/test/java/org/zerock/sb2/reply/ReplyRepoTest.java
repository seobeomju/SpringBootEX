package org.zerock.sb2.reply;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.zerock.sb2.board.entities.BoardEntity;
import org.zerock.sb2.reply.entities.ReplyEntity;
import org.zerock.sb2.reply.repository.ReplyRepository;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class ReplyRepoTest {

    @Autowired(required = false)
    private ReplyRepository repository;

    @Test
    public void testInsert(){

        for (int i = 0; i < 25; i++) {
                   //가짜 BoardEntity필요
        BoardEntity board = BoardEntity.builder().bno(123L).build();

        ReplyEntity replyEntity = ReplyEntity.builder()
        .replyText("댓글입니다. 댓글입니다.")
        .replyer("user00")
        .board(board)
        .build();

        repository.save(replyEntity);
        }
 
    }

    @Test
    public void testRead(){
  
      Long rno = 1L;
  
      Optional<ReplyEntity> result = repository.findById(rno);
  
      ReplyEntity reply = result.orElseThrow();
  
      log.info(reply);
  
    }

    @Test
    public void testlistofBoard(){
      Long bno =123L;
      Pageable pageable = PageRequest.of(0,10,Sort.by("rno").descending());
      repository.listofBoard(bno, pageable);
    }
  
    @Test
    public void testlistofBoard2(){
      Long bno =123L;
      Pageable pageable = PageRequest.of(0,10,Sort.by("rno").descending());
      Page<Object[]>result = repository.listofBoard2(bno, pageable);
      result.getContent().forEach(arr -> log.info(Arrays.toString(arr)));
    }
}
