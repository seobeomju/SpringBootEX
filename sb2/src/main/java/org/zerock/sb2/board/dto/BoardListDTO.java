package org.zerock.sb2.board.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BoardListDTO {
    private Long bno;
    
    private String title;
    
    private String  writer;
    
    private LocalDateTime regDate;
    
    private int viewCnt;
    
    public BoardListDTO(Long bno, String title, String writer, LocalDateTime regDate, int viewCnt) {
        this.bno = bno;
        this.title = title;
        this.writer = writer;
        this.regDate = regDate;
        this.viewCnt = viewCnt;
    }
    
    
}
