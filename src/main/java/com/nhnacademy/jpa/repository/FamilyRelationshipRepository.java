package com.nhnacademy.jpa.repository;

import com.nhnacademy.jpa.domain.FamilyRelationshipRegisterRequest;
import com.nhnacademy.jpa.entity.FamilyRelationship;
import com.nhnacademy.jpa.enums.FamilyRelationshipCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface FamilyRelationshipRepository extends JpaRepository<FamilyRelationship, FamilyRelationship.Pk>, FamilyRelationshipRepositoryCustom {
    @Modifying
    @Transactional
    @Query(value = "insert into family_relationship VALUES (:baseId, :familyId, :relationship)", nativeQuery = true)
    void insert(@Param("baseId") Long baseResidentId, @Param("familyId") Long familyResidentId, @Param("relationship") String relationship);

    @Modifying
    @Transactional
    @Query(value = "update FamilyRelationship f set f.relationship = ?3 " +
            "where f.pk.baseResidentId = ?1 and f.pk.familyResidentId = ?2 ")
    void update(@Param("baseId") Long baseResidentId, @Param("familyId") Long familyResidentId, @Param("relationship") FamilyRelationshipCode relationship);

    @Transactional
    void deleteByPk(FamilyRelationship.Pk pk);
}
