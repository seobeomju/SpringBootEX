package org.zerock.sb2.reply.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.sb2.reply.dto.ReplyAddDTO;
import org.zerock.sb2.reply.entities.ReplyEntity;
import org.zerock.sb2.reply.repository.ReplyRepository;

@Service
@Transactional
@RequiredArgsConstructor
@Log4j2
public class ReplyServiceImpl implements ReplyService {

    private final ReplyRepository replyRepository;

    @Override
    public Long add(ReplyAddDTO addDTO) {

        ReplyEntity entity = dtoToEntity(addDTO);
        replyRepository.save(entity);

        return entity.getRno();
    }
}
