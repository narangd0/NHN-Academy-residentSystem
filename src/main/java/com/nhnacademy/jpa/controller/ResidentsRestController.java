package com.nhnacademy.jpa.controller;

import com.nhnacademy.jpa.domain.ResidentRegisterRequest;
import com.nhnacademy.jpa.entity.Resident;
import com.nhnacademy.jpa.exception.ValidationFailedException;
import com.nhnacademy.jpa.service.ResidentService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/residents")
public class ResidentsRestController {
    private final ResidentService residentService;

    public ResidentsRestController(ResidentService residentService) {
        this.residentService = residentService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Resident createResident(@Valid @RequestBody ResidentRegisterRequest registerRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationFailedException(bindingResult);
        }

        return residentService.createResident(registerRequest);
    }

}
