package com.nhnacademy.jpa.domain;

import com.nhnacademy.jpa.enums.FamilyRelationshipCode;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class FamilyRelationshipRegisterRequest {
    @NotNull
    private Long familyResidentId;

    @NotNull
    private FamilyRelationshipCode relationship;
}
