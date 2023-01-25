package com.nhnacademy.jpa.repository;

import com.nhnacademy.jpa.domain.FamilyRelationshipDto;
import com.nhnacademy.jpa.domain.QFamilyRelationshipCertificateInfo;
import com.nhnacademy.jpa.domain.QFamilyRelationshipDto;
import com.nhnacademy.jpa.entity.FamilyRelationship;
import com.nhnacademy.jpa.entity.QCertificateIssue;
import com.nhnacademy.jpa.entity.QFamilyRelationship;
import com.nhnacademy.jpa.entity.QResident;
import com.nhnacademy.jpa.enums.CertificateTypeCode;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class FamilyRelationshipRepositoryImpl extends QuerydslRepositorySupport implements FamilyRelationshipRepositoryCustom {
    public FamilyRelationshipRepositoryImpl() {
        super(FamilyRelationship.class);
    }
    /*
    select f.family_relationship_code, r2.name, r2.birth_date, r2.resident_registration_number, r2.gender_code
    from resident r inner join family_relationship f on r.resident_serial_number = f.base_resident_serial_number
	inner join resident r2 on f.family_resident_serial_number = r2.resident_serial_number
    where r.resident_serial_number = 4;
     */
    @Override
    public List<FamilyRelationshipDto> getFamilyInfo(Long residentId) {
        QFamilyRelationship familyRelationship = QFamilyRelationship.familyRelationship;
        QResident resident = QResident.resident;
        QResident resident2 = new QResident("resident2");

        return from(resident)
                .innerJoin(familyRelationship).on(resident.id.eq(familyRelationship.baseResident.id))
                .innerJoin(resident2).on(familyRelationship.pk.familyResidentId.eq(resident2.id))
                .where(resident.id.eq(residentId))
                .select(new QFamilyRelationshipDto(familyRelationship.relationship, resident2.name, resident2.birthDate, resident2.registrationNumber, resident2.gender))
                .fetch();
    }
}
