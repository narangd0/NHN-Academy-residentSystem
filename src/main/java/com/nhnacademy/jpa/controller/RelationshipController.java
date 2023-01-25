package com.nhnacademy.jpa.controller;

import com.nhnacademy.jpa.domain.FamilyRelationshipModifyRequest;
import com.nhnacademy.jpa.domain.FamilyRelationshipRegisterRequest;
import com.nhnacademy.jpa.domain.ResidentModifyRequest;
import com.nhnacademy.jpa.domain.ResidentRegisterRequest;
import com.nhnacademy.jpa.entity.FamilyRelationship;
import com.nhnacademy.jpa.entity.Resident;
import com.nhnacademy.jpa.enums.FamilyRelationshipCode;
import com.nhnacademy.jpa.exception.ResidentNotFoundException;
import com.nhnacademy.jpa.exception.ValidationFailedException;
import com.nhnacademy.jpa.service.FamilyRelationshipService;
import com.nhnacademy.jpa.service.ResidentService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

@RestController
@RequestMapping("/residents/{baseResidentId}/relationship")
public class RelationshipController {
    private final FamilyRelationshipService familyRelationshipService;
    private final ResidentService residentService;

    public RelationshipController(FamilyRelationshipService familyRelationshipService, ResidentService residentService) {
        this.familyRelationshipService = familyRelationshipService;
        this.residentService = residentService;
    }

    @ModelAttribute(value = "baseResidentId", binding = false)
    public Long getResident(@PathVariable("baseResidentId") Long baseResidentId) {
        Resident resident = residentService.getResident(baseResidentId);
        if (Objects.isNull(resident)) {
            throw new ResidentNotFoundException();
        }
        return baseResidentId;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createRelationship(@ModelAttribute("baseResidentId") Long baseId,
                                                 @Valid @RequestBody FamilyRelationshipRegisterRequest registerRequest,
                                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationFailedException(bindingResult);
        }

        familyRelationshipService.createRelationship(baseId, registerRequest);
    }

    @PutMapping("/{familyResidentId}")
    public void modifyRelationship(@ModelAttribute("baseResidentId") Long baseId,
                                       @PathVariable("familyResidentId") Long familyId,
                                       @RequestBody FamilyRelationshipModifyRequest request) {
        familyRelationshipService.modifyRelationship(baseId, familyId, request);
    }

    @DeleteMapping("/{familyResidentId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteRelationship(@ModelAttribute("baseResidentId") Long baseId,
                                   @PathVariable("familyResidentId") Long familyId) {
        FamilyRelationship.Pk pk = new FamilyRelationship.Pk(baseId, familyId);
        familyRelationshipService.deleteRelationship(pk);
    }
}
