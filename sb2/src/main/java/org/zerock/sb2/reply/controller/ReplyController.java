package org.zerock.sb2.reply.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.sb2.reply.dto.ReplyAddDTO;
import org.zerock.sb2.reply.service.ReplyService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/replies")
@RequiredArgsConstructor
@Log4j2
public class ReplyController {

    private final ReplyService service;

    @PostMapping("")
    public ResponseEntity<Map<String, String>> add(
            @Valid @RequestBody ReplyAddDTO dto, BindingResult bindingResult){


        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error ->
                    errors.put(error.getField(), error.getDefaultMessage())
            );
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        }

        Long rno = service.add(dto);

        return ResponseEntity.ok(Map.of("rno", String.valueOf(rno)));


    }


}
