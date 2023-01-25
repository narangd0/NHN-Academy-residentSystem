package com.nhnacademy.jpa.controller;

import com.nhnacademy.jpa.domain.BirthReportModifyRequest;
import com.nhnacademy.jpa.domain.DeathReportModifyRequest;
import com.nhnacademy.jpa.domain.DeathReportRegisterRequest;
import com.nhnacademy.jpa.entity.Resident;
import com.nhnacademy.jpa.exception.ResidentNotFoundException;
import com.nhnacademy.jpa.exception.ValidationFailedException;
import com.nhnacademy.jpa.service.BirthDeathReportResidentService;
import com.nhnacademy.jpa.service.ResidentService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

@RestController
@RequestMapping("/residents/{serialNumber}/death")
public class DeathReportController {
    private final ResidentService residentService;
    private final BirthDeathReportResidentService birthDeathReportResidentService;

    public DeathReportController(ResidentService residentService, BirthDeathReportResidentService birthDeathReportResidentService) {
        this.residentService = residentService;
        this.birthDeathReportResidentService = birthDeathReportResidentService;
    }

    @ModelAttribute(value = "reportResident", binding = false)
    public Resident getReportResident(@PathVariable("serialNumber") Long reportResidentId) {
        Resident resident = residentService.getResident(reportResidentId);
        if (Objects.isNull(resident)) {
            throw new ResidentNotFoundException();
        }
        return resident;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DeathReportRegisterRequest registerDeathReport(@ModelAttribute("reportResident") Resident reportResident,
                                                          @Valid @RequestBody DeathReportRegisterRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationFailedException(bindingResult);
        }

        return birthDeathReportResidentService.registerDeathReport(reportResident, request);
    }

    @PutMapping("/{targetSerialNumber}")
    public DeathReportModifyRequest modifyDeathReport(@ModelAttribute("reportResident") Resident reportResident,
                                                      @PathVariable("targetSerialNumber") Long targetResidentId,
                                                      @Valid @RequestBody DeathReportModifyRequest request,
                                                      BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationFailedException(bindingResult);
        }

        return birthDeathReportResidentService.modifyDeathReport(reportResident.getId(), targetResidentId, request);
    }

    @DeleteMapping("/{targetSerialNumber}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteDeathReport(@ModelAttribute("reportResident") Resident reportResident,
                                   @PathVariable("targetSerialNumber") Long targetResidentId) {
        birthDeathReportResidentService.deleteDeathReport(reportResident.getId(), targetResidentId);
    }
}
