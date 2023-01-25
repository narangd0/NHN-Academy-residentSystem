package com.nhnacademy.jpa.repository;

import com.nhnacademy.jpa.domain.FamilyRelationshipCertificateInfo;
import com.nhnacademy.jpa.domain.QFamilyRelationshipCertificateInfo;
import com.nhnacademy.jpa.entity.CertificateIssue;
import com.nhnacademy.jpa.entity.QCertificateIssue;
import com.nhnacademy.jpa.entity.QResident;
import com.nhnacademy.jpa.enums.CertificateTypeCode;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import static com.querydsl.jpa.JPAExpressions.select;

public class CertificateIssueRepositoryImpl extends QuerydslRepositorySupport implements CertificateIssueRepositoryCustom {
    public CertificateIssueRepositoryImpl() {
        super(CertificateIssue.class);
    }

    /*
    select c.certificate_issue_date, c.certificate_confirmation_number, r.registration_base_address
    from resident r inner join certificate_issue c on r.resident_serial_number = c.resident_serial_number
    where c.certificate_type_code = '가족관계증명서';
     */
    @Override
    public FamilyRelationshipCertificateInfo getFamilyRelationshipCertificateInfo(Long residentId) {
        QCertificateIssue certificateIssue = QCertificateIssue.certificateIssue;
        QResident resident = QResident.resident;

        return from(certificateIssue)
                .innerJoin(certificateIssue.resident, resident)
//                .fetchJoin()
                .where(certificateIssue.certificateType.eq(CertificateTypeCode.가족관계증명서))
                .where(resident.id.eq(residentId))
                .select(new QFamilyRelationshipCertificateInfo(certificateIssue.id, certificateIssue.issueDate, certificateIssue.resident))
                .orderBy(certificateIssue.issueDate.desc())
                .fetchOne();
    }
}
