package org.zerock.sb2.reply.service;

import org.zerock.sb2.board.entities.BoardEntity;
import org.zerock.sb2.reply.dto.ReplyAddDTO;
import org.zerock.sb2.reply.entities.ReplyEntity;

public interface ReplyService {
    Long add(ReplyAddDTO addDTO);

    default ReplyEntity dtoToEntity(ReplyAddDTO addDTO) {
        return ReplyEntity.builder()
                .replyText(addDTO.getReplyText())
                .replyer(addDTO.getReplyer())
                .board(BoardEntity.builder().bno(addDTO.getBno()).build())
                .build();
    }

}
