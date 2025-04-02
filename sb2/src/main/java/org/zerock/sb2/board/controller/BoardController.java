package org.zerock.sb2.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.sb2.board.dto.BoardRegisterDTO;
import org.zerock.sb2.board.dto.PageRequestDTO;
import org.zerock.sb2.board.service.BoardService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/board")
@Log4j2
@RequiredArgsConstructor
public class BoardController {

  private final BoardService service;

  @GetMapping("list")
  public void list( @ModelAttribute("requestDTO") PageRequestDTO requestDTO, Model model ) {
  
    log.info("Board list............");

    model.addAttribute("data", service.list(requestDTO));
    
  }
  
  @GetMapping("register")
  public void register(){

  }
  
  @PostMapping("register")
  public String postMethodNAme(@Valid BoardRegisterDTO dto, BindingResult bindingResult, RedirectAttributes rttr){

    log.info("-----------------");
    log.info(dto);
    log.info(bindingResult);

    if(bindingResult.hasErrors()){
      log.info("has errors...........");
      rttr.addFlashAttribute("errors",bindingResult.getAllErrors());

      return "redirect:/board/register";
    }


    return "/board/list";
  }
}
