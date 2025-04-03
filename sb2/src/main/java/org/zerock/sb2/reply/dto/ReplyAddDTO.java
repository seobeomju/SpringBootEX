package org.zerock.sb2.reply.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReplyAddDTO {


    @NotBlank
    private String replyText;

    @NotBlank
    private String replyer;

    @NotBlank
    private Long bno;
}
