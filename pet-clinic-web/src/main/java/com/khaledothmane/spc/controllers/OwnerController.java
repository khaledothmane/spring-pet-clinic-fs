package com.khaledothmane.spc.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping({"/owners"})
@Controller
public class OwnerController {

    @RequestMapping({"", "/", "/index.html"})
    public String ownersList() {
        return "owners/index";
    }
}
