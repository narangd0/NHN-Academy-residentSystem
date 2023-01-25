package com.nhnacademy.jpa.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nhnacademy.jpa.enums.BirthPlaceCode;
import com.nhnacademy.jpa.enums.DeathPlaceCode;
import com.nhnacademy.jpa.enums.GenderCode;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class ResidentRegisterRequest {
    @NotNull
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String registrationNumber;

    @NotNull
    private GenderCode gender;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime birthDate;

    @NotNull
    private BirthPlaceCode birthPlace;

    @NotBlank
    private String registrationBaseAddress;

    private LocalDateTime deathDate;
    private DeathPlaceCode deathPlace;
    private String deathPlaceAddress;
}
