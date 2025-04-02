package org.zerock.sb2.reply.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ReplyListDTO {
    private Long rno;
    private String replyText;
    private String replyer;
    private Long bno;

    private LocalDateTime regDate;
    private LocalDateTime modDate;
}
