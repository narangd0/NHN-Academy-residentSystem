package com.nhnacademy.jpa.service;

import com.nhnacademy.jpa.domain.FamilyRelationshipCertificateInfo;
import com.nhnacademy.jpa.domain.FamilyRelationshipDto;

import java.util.List;

public interface CertificateIssueService {
    FamilyRelationshipCertificateInfo getFamilyRelationshipCertificateInfo(Long residentId);
}
