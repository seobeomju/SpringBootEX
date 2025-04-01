package org.zerock.sb3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sample")
public class SampleController {
    @GetMapping("ex1")
    public void ex1(Model model){

        String[] arr = new String[]{"AAA","BBBB","CCC"};
        model.addAttribute("list", arr);

    }
}
