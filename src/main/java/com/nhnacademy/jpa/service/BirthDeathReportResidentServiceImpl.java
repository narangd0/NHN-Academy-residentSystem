package com.nhnacademy.jpa.service;

import com.nhnacademy.jpa.domain.BirthReportModifyRequest;
import com.nhnacademy.jpa.domain.BirthReportRegisterRequest;
import com.nhnacademy.jpa.domain.DeathReportModifyRequest;
import com.nhnacademy.jpa.domain.DeathReportRegisterRequest;
import com.nhnacademy.jpa.entity.BirthDeathReportResident;
import com.nhnacademy.jpa.entity.Resident;
import com.nhnacademy.jpa.enums.BirthDeathTypeCode;
import com.nhnacademy.jpa.exception.BirthDeathReportResidentNotFoundException;
import com.nhnacademy.jpa.repository.BirthDeathReportResidentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BirthDeathReportResidentServiceImpl implements BirthDeathReportResidentService {
    private final BirthDeathReportResidentRepository birthDeathReportResidentRepository;
    private final ResidentService residentService;

    public BirthDeathReportResidentServiceImpl(BirthDeathReportResidentRepository birthDeathReportResidentRepository, ResidentService residentService) {
        this.birthDeathReportResidentRepository = birthDeathReportResidentRepository;
        this.residentService = residentService;
    }

    @Override
    public BirthReportRegisterRequest registerBirthReport(Resident reportResident, BirthReportRegisterRequest request) {
        BirthDeathReportResident.Pk pk = new BirthDeathReportResident.Pk(request.getTargetResidentId(), BirthDeathTypeCode.출생);
        Resident targetResident = residentService.getResident(request.getTargetResidentId());
//        Resident reportResident = residentService.getResident(reportResidentId);

        BirthDeathReportResident birthDeathReportResident = new BirthDeathReportResident(
                pk,
                targetResident,
                reportResident,
                request.getReportDate(),
                request.getBirthReportQualifications(),
                null,
                request.getEmailAddress(),
                request.getPhoneNumber());

        birthDeathReportResidentRepository.save(birthDeathReportResident);

        return request;
    }

    @Override
    public BirthReportModifyRequest modifyBirthReport(Long reportResidentId, Long targetResidentId, BirthReportModifyRequest request) {
        BirthDeathReportResident.Pk pk = new BirthDeathReportResident.Pk(targetResidentId, BirthDeathTypeCode.출생);
        Optional<BirthDeathReportResident> birthDeathReportResident = birthDeathReportResidentRepository.findById(pk);

        if (birthDeathReportResident.isEmpty())
            throw new BirthDeathReportResidentNotFoundException();

        birthDeathReportResident.get().modifyBirthReport(request);

        birthDeathReportResidentRepository.save(birthDeathReportResident.get());

        // TODO Dto 만들어서 리턴해주기 (수정된 레코드 정보 보여주기)
        return request;
    }

    @Override
    public void deleteBirthReport(Long reportResidentId, Long targetResidentId) {
        birthDeathReportResidentRepository.deleteBy(reportResidentId, targetResidentId, BirthDeathTypeCode.출생);
    }

    @Override
    public DeathReportRegisterRequest registerDeathReport(Resident reportResident, DeathReportRegisterRequest request) {
        BirthDeathReportResident.Pk pk = new BirthDeathReportResident.Pk(request.getTargetResidentId(), BirthDeathTypeCode.사망);
        Resident targetResident = residentService.getResident(request.getTargetResidentId());
//        Resident reportResident = residentService.getResident(reportResidentId);

        BirthDeathReportResident birthDeathReportResident = new BirthDeathReportResident(
                pk,
                targetResident,
                reportResident,
                request.getReportDate(),
                null,
                request.getDeathReportQualifications(),
                request.getEmailAddress(),
                request.getPhoneNumber());

        birthDeathReportResidentRepository.save(birthDeathReportResident);

        return request;
    }

    @Override
    public DeathReportModifyRequest modifyDeathReport(Long reportResidentId, Long targetResidentId, DeathReportModifyRequest request) {
        BirthDeathReportResident.Pk pk = new BirthDeathReportResident.Pk(targetResidentId, BirthDeathTypeCode.사망);
        Optional<BirthDeathReportResident> birthDeathReportResident = birthDeathReportResidentRepository.findById(pk);

        if (birthDeathReportResident.isEmpty())
            throw new BirthDeathReportResidentNotFoundException();

        birthDeathReportResident.get().modifyDeathReport(request);

        birthDeathReportResidentRepository.save(birthDeathReportResident.get());

        // TODO Dto 만들어서 리턴해주기 (수정된 레코드 정보 보여주기)
        return request;
    }

    @Override
    public void deleteDeathReport(Long reportResidentId, Long targetResidentId) {
        birthDeathReportResidentRepository.deleteBy(reportResidentId, targetResidentId, BirthDeathTypeCode.사망);
    }
}
