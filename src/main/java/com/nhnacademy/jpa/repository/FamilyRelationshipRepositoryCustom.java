package com.nhnacademy.jpa.repository;

import com.nhnacademy.jpa.domain.FamilyRelationshipDto;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface FamilyRelationshipRepositoryCustom {
    List<FamilyRelationshipDto> getFamilyInfo(Long residentId);
}
