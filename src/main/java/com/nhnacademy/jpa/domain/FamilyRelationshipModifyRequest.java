package com.nhnacademy.jpa.domain;

import com.nhnacademy.jpa.enums.FamilyRelationshipCode;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class FamilyRelationshipModifyRequest {
    @NotNull
    private FamilyRelationshipCode relationship;
}
