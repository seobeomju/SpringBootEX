package org.zerock.sb2.reply.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class ReplyAddDTO {


    @NotBlank
    private String replyText;

    @NotBlank
    private String replyer;

    @NotBlank
    private Long bno;
}
