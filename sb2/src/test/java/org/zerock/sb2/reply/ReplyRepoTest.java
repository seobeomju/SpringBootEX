package org.zerock.sb2.reply;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.sb2.board.entities.BoardEntity;
import org.zerock.sb2.reply.repository.ReplyRepository;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class ReplyRepoTest {

    @Autowired(required = false)
    private ReplyRepository repository;

    @Test
    public void testInsert(){
        //가짜 BoardEntity필요
        BoardEntity board = BoardEntity.builder().bno(123L).build();
    }
}
