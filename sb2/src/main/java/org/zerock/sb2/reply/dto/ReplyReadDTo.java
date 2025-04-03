package org.zerock.sb2.reply.dto;

import java.time.LocalDateTime;

import org.zerock.sb2.reply.entities.ReplyEntity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReplyReadDTo {

    private Long rno;

    private String  replyText;

    private String replyer;

    private LocalDateTime regDAte;

    private LocalDateTime modDate;

    private Long bno;
    
    public ReplyReadDTo(ReplyEntity entity){
        this.rno = entity.getRno();
        this.replyText = entity.getReplyText();
        this.replyer = entity.getReplyer();
        this.regDAte = entity.getRegDate();
        this.modDate = entity.getModDate();

        this.bno = entity.getBoard().getBno();
    }
}
