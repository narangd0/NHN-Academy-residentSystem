package com.nhnacademy.jpa.repository;

import com.nhnacademy.jpa.entity.Resident;
import com.nhnacademy.jpa.entity.ResidentDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResidentRepository extends JpaRepository<Resident, Long> {
//    Page<Resident> getAllBy(Pageable pageable);
    Page<ResidentDto> getAllBy(Pageable pageable);
}
