package com.nhnacademy.jpa.domain;

import com.nhnacademy.jpa.entity.Resident;
import com.nhnacademy.jpa.enums.FamilyRelationshipCode;
import com.nhnacademy.jpa.enums.GenderCode;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class FamilyRelationshipDto {
    private FamilyRelationshipCode familyRelationship;
    private String name;
    private LocalDateTime birthDate;
    private String registrationNumber;
    private GenderCode gender;

    @QueryProjection
    public FamilyRelationshipDto(FamilyRelationshipCode familyRelationship, String name, LocalDateTime birthDate, String registrationNumber, GenderCode gender) {
        this.familyRelationship = familyRelationship;
        this.name = name;
        this.birthDate = birthDate;
        this.registrationNumber = registrationNumber;
        this.gender = gender;
    }
}
