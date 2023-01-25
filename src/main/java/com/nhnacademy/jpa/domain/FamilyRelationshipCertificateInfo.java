package com.nhnacademy.jpa.domain;

import com.nhnacademy.jpa.entity.Resident;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

import java.time.LocalDate;

@Data
public class FamilyRelationshipCertificateInfo {
    private Long id;
    private LocalDate issueDate;
    private Resident resident;

    @QueryProjection
    public FamilyRelationshipCertificateInfo(Long id, LocalDate issueDate, Resident resident) {
        this.id = id;
        this.issueDate = issueDate;
        this.resident = resident;
    }
}
