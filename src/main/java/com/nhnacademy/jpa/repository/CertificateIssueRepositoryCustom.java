package com.nhnacademy.jpa.repository;

import com.nhnacademy.jpa.domain.FamilyRelationshipCertificateInfo;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CertificateIssueRepositoryCustom {
    FamilyRelationshipCertificateInfo getFamilyRelationshipCertificateInfo(Long residentId);
}
