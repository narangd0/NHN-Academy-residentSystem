package com.nhnacademy.jpa.service;

import com.nhnacademy.jpa.domain.ResidentModifyRequest;
import com.nhnacademy.jpa.domain.ResidentRegisterRequest;
import com.nhnacademy.jpa.entity.Resident;
import com.nhnacademy.jpa.entity.ResidentDto;
import com.nhnacademy.jpa.exception.ValidationFailedException;
import com.nhnacademy.jpa.repository.ResidentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ResidentServiceImpl implements ResidentService {
    private final ResidentRepository residentRepository;

    public ResidentServiceImpl(ResidentRepository residentRepository) {
        this.residentRepository = residentRepository;
    }

    @Override
    public Resident getResident(Long residentId) {
        return residentRepository.findById(residentId).orElse(null);
    }

    @Transactional
    @Override
    public Resident createResident(ResidentRegisterRequest registerRequest) {
        Resident resident = new Resident(registerRequest.getId(),
                registerRequest.getName(),
                registerRequest.getRegistrationNumber(),
                registerRequest.getGender(),
                registerRequest.getBirthDate(),
                registerRequest.getBirthPlace(),
                registerRequest.getRegistrationBaseAddress(),
                registerRequest.getDeathDate(),
                registerRequest.getDeathPlace(),
                registerRequest.getDeathPlaceAddress());

        return residentRepository.save(resident);
    }

    @Override
    public Page<ResidentDto> getAllBy(Pageable pageable) {
        return residentRepository.getAllBy(pageable);
    }

    @Override
    public void deleteResident(Long id) {
        residentRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Resident modifyResident(Resident resident) {
        return residentRepository.save(resident);
    }
}
