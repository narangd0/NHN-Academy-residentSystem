package com.nhnacademy.jpa.service;

import com.nhnacademy.jpa.domain.FamilyRelationshipDto;
import com.nhnacademy.jpa.domain.FamilyRelationshipModifyRequest;
import com.nhnacademy.jpa.domain.FamilyRelationshipRegisterRequest;
import com.nhnacademy.jpa.entity.FamilyRelationship;
import com.nhnacademy.jpa.entity.Resident;
import com.nhnacademy.jpa.enums.FamilyRelationshipCode;

import java.util.List;

public interface FamilyRelationshipService {
    void createRelationship(Long baseResidentId, FamilyRelationshipRegisterRequest request);
    void modifyRelationship(Long baseResidentId, Long familyResidentId, FamilyRelationshipModifyRequest request);

    // TODO controller layer에서 pk를 받지 말고 service layer에서 pk 생성하도록 변경
    void deleteRelationship(FamilyRelationship.Pk pk);

    List<FamilyRelationshipDto> getFamilyInfo(Long residentId);

}