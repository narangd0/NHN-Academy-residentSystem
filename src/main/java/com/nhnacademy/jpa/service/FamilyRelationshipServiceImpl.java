package com.nhnacademy.jpa.service;

import com.nhnacademy.jpa.domain.FamilyRelationshipDto;
import com.nhnacademy.jpa.domain.FamilyRelationshipModifyRequest;
import com.nhnacademy.jpa.domain.FamilyRelationshipRegisterRequest;
import com.nhnacademy.jpa.entity.FamilyRelationship;
import com.nhnacademy.jpa.enums.FamilyRelationshipCode;
import com.nhnacademy.jpa.repository.FamilyRelationshipRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FamilyRelationshipServiceImpl implements FamilyRelationshipService {
    private final FamilyRelationshipRepository familyRelationshipRepository;

    public FamilyRelationshipServiceImpl(FamilyRelationshipRepository familyRelationshipRepository) {
        this.familyRelationshipRepository = familyRelationshipRepository;
    }

    @Transactional
    @Override
    public void createRelationship(Long baseResidentId, FamilyRelationshipRegisterRequest request) {
        familyRelationshipRepository.insert(baseResidentId, request.getFamilyResidentId(), request.getRelationship().toString());
    }

    @Override
    public void modifyRelationship(Long baseResidentId, Long familyResidentId, FamilyRelationshipModifyRequest request) {
        familyRelationshipRepository.update(baseResidentId, familyResidentId, request.getRelationship());
    }

    @Override
    public void deleteRelationship(FamilyRelationship.Pk pk) {
        familyRelationshipRepository.deleteByPk(pk);
    }

    @Override
    public List<FamilyRelationshipDto> getFamilyInfo(Long residentId) {
        return familyRelationshipRepository.getFamilyInfo(residentId);
    }
}
