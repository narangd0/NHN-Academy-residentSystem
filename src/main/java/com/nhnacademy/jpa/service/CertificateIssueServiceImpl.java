package com.nhnacademy.jpa.service;

import com.nhnacademy.jpa.domain.FamilyRelationshipCertificateInfo;
import com.nhnacademy.jpa.domain.FamilyRelationshipDto;
import com.nhnacademy.jpa.repository.CertificateIssueRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificateIssueServiceImpl implements CertificateIssueService {
    private final CertificateIssueRepository certificateIssueRepository;

    public CertificateIssueServiceImpl(CertificateIssueRepository certificateIssueRepository) {
        this.certificateIssueRepository = certificateIssueRepository;
    }

    @Override
    public FamilyRelationshipCertificateInfo getFamilyRelationshipCertificateInfo(Long residentId) {
        return certificateIssueRepository.getFamilyRelationshipCertificateInfo(residentId);
    }
}
