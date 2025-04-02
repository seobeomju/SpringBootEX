package org.zerock.sb2.board.dto;

import jakarta.validation.constraints.NotBlank;

public class BoardRegisterDTO {
    
    @NotBlank
    private String title;

    @NotBlank
    private String content;

    @NotBlank
    private String writer;
}
