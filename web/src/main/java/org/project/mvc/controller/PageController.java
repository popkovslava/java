package org.project.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.project.service.PageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    private final PageService pageService;

    @Autowired
    public PageController(PageService pageService){
        this.pageService=pageService;
    }
    //@PathVariable(value = "id") Long id
    @GetMapping("/")
    public  String showPage(Model model) {
        //model.addAttribute("userListId",pageService.pages().findById(id).orElse(null));
      //  model.addAttribute("userList",pageService.pages().findAll());
        return "page";
    }
}


