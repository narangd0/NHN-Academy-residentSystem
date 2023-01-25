package com.nhnacademy.jpa.service;

import com.nhnacademy.jpa.domain.ResidentRegisterRequest;
import com.nhnacademy.jpa.entity.Resident;
import com.nhnacademy.jpa.entity.ResidentDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ResidentService {
    Resident modifyResident(Resident resident);

    Resident getResident(Long residentId);

    Resident createResident(ResidentRegisterRequest registerRequest);

    Page<ResidentDto> getAllBy(Pageable pageable);

    void deleteResident(Long id);
}
