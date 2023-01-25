package com.nhnacademy.jpa.repository;

import com.nhnacademy.jpa.entity.BirthDeathReportResident;
import com.nhnacademy.jpa.enums.BirthDeathTypeCode;
import com.nhnacademy.jpa.enums.BirthReportQualificationsCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface BirthDeathReportResidentRepository extends JpaRepository<BirthDeathReportResident, BirthDeathReportResident.Pk> {
    @Transactional
    @Modifying
    @Query("delete from BirthDeathReportResident b " +
            "where b.pk.birthDeathType = ?3 " +
            "and b.pk.targetResidentId = ?2 " +
            "and b.reportResident.id = ?1")
    void deleteBy(@Param("reportResidentId") Long reportResidentId,
                  @Param("targetResidentId") Long targetResidentId,
                  @Param("birthReportQualifications") BirthDeathTypeCode birthReportQualifications);
}
