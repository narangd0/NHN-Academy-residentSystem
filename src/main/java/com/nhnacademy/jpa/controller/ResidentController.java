package com.nhnacademy.jpa.controller;

import com.nhnacademy.jpa.entity.Resident;
import com.nhnacademy.jpa.entity.ResidentDto;
import com.nhnacademy.jpa.service.ResidentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/residents")
public class ResidentController {
    private final ResidentService residentService;

    public ResidentController(ResidentService residentService) {
        this.residentService = residentService;
    }

    @GetMapping
    public String getResidentListView(Pageable pageable, Model model) {
        Page<ResidentDto> page = residentService.getAllBy(pageable);
        model.addAttribute("residentList", page.getContent());
        model.addAttribute("pageable", pageable);
        // TODO pagination
        return "residentList";
    }

}


