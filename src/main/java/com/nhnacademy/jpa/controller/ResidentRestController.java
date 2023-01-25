package com.nhnacademy.jpa.controller;

import com.nhnacademy.jpa.domain.ResidentModifyRequest;
import com.nhnacademy.jpa.entity.FamilyRelationship;
import com.nhnacademy.jpa.entity.Resident;
import com.nhnacademy.jpa.exception.ResidentNotFoundException;
import com.nhnacademy.jpa.exception.ValidationFailedException;
import com.nhnacademy.jpa.service.ResidentService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

@RestController
@RequestMapping("/residents/{residentId}")
public class ResidentRestController {
    private final ResidentService residentService;

    public ResidentRestController(ResidentService residentService) {
        this.residentService = residentService;
    }

    @ModelAttribute(value = "resident", binding = false)
    public Resident getResident(@PathVariable("residentId") Long residentId) {
        Resident resident = residentService.getResident(residentId);
        if (Objects.isNull(resident)) {
            throw new ResidentNotFoundException();
        }

        return resident;
    }

    @GetMapping
    public Resident getResident(@ModelAttribute("resident") Resident resident) {
        return resident;
    }

    @PutMapping
    public Resident modifyResident(@ModelAttribute("resident") Resident resident,
                           @Valid @RequestBody ResidentModifyRequest request,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationFailedException(bindingResult);
        }

        resident.modify(request);

        return residentService.modifyResident(resident);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteResident(@ModelAttribute("resident") Resident resident) {
        residentService.deleteResident(resident.getId());
    }

}
