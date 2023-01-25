package com.nhnacademy.jpa.service;


import com.nhnacademy.jpa.domain.BirthReportModifyRequest;
import com.nhnacademy.jpa.domain.BirthReportRegisterRequest;
import com.nhnacademy.jpa.domain.DeathReportModifyRequest;
import com.nhnacademy.jpa.domain.DeathReportRegisterRequest;
import com.nhnacademy.jpa.entity.Resident;

public interface BirthDeathReportResidentService {
    BirthReportRegisterRequest registerBirthReport(Resident reportResident, BirthReportRegisterRequest request);
    BirthReportModifyRequest modifyBirthReport(Long reportResidentId, Long targetResidentId, BirthReportModifyRequest request);

    void deleteBirthReport(Long reportResidentId, Long targetResidentId);
    DeathReportRegisterRequest registerDeathReport(Resident reportResident, DeathReportRegisterRequest request);

    DeathReportModifyRequest modifyDeathReport(Long reportResidentId, Long targetResidentId, DeathReportModifyRequest request);

    void deleteDeathReport(Long reportResidentId, Long targetResidentId);
}
