package com.nhnacademy.jpa.domain;

import com.nhnacademy.jpa.enums.BirthPlaceCode;
import com.nhnacademy.jpa.enums.DeathPlaceCode;
import com.nhnacademy.jpa.enums.GenderCode;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
public class ResidentModifyRequest {
    private Long id;

    private String name;

    private String registrationNumber;

    private GenderCode gender;

    private LocalDateTime birthDate;

    private BirthPlaceCode birthPlace;

    private String registrationBaseAddress;

    private LocalDateTime deathDate;

    private DeathPlaceCode deathPlace;
    private String deathPlaceAddress;
}
