package com.nhnacademy.jpa.controller;

import com.nhnacademy.jpa.domain.FamilyRelationshipRegisterRequest;
import com.nhnacademy.jpa.domain.HouseholdRegisterRequest;
import com.nhnacademy.jpa.exception.ValidationFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/household")
public class HouseholdController {
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void registerHousehold(@Valid @RequestBody HouseholdRegisterRequest request,
                                   BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationFailedException(bindingResult);
        }
    }
}
