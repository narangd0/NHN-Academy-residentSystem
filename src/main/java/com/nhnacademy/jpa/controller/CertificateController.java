package com.nhnacademy.jpa.controller;

import com.nhnacademy.jpa.domain.FamilyRelationshipCertificateInfo;
import com.nhnacademy.jpa.domain.FamilyRelationshipDto;
import com.nhnacademy.jpa.entity.CertificateIssue;
import com.nhnacademy.jpa.service.CertificateIssueService;
import com.nhnacademy.jpa.service.FamilyRelationshipService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/certificate")
public class CertificateController {
    private final CertificateIssueService certificateIssueService;
    private final FamilyRelationshipService familyRelationshipService;

    public CertificateController(CertificateIssueService certificateIssueService, FamilyRelationshipService familyRelationshipService) {
        this.certificateIssueService = certificateIssueService;
        this.familyRelationshipService = familyRelationshipService;
    }

    @GetMapping("/familyRelationshipCertificate/{residentId}")
    public String getFamilyRelationshipCertificateView(@PathVariable("residentId") Long residentId, Model model) {
        FamilyRelationshipCertificateInfo info = certificateIssueService.getFamilyRelationshipCertificateInfo(residentId);
        List<FamilyRelationshipDto> familyInfoList = familyRelationshipService.getFamilyInfo(residentId);

        model.addAttribute("info", info);
        model.addAttribute("familyInfoList", familyInfoList);
        return "familyRelationshipCertificate";
    }
}
