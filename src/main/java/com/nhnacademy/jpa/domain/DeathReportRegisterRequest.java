package com.nhnacademy.jpa.domain;

import com.nhnacademy.jpa.enums.BirthReportQualificationsCode;
import com.nhnacademy.jpa.enums.DeathReportQualificationsCode;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class DeathReportRegisterRequest {
//    insert into birth_death_report_resident values (7, '출생', 4, '20120317', '부', null, 'nam@nhnad.co.kr', '010-1234-5678');
//    피신고자Id, '출생', //신고자Id//, 신고일, 신고인과의 관계, null, 이메일, 전화번호

    @NotNull
    private Long targetResidentId;

//    @NotNull
//    private BirthDeathTypeCode birthDeathType;

//    @NotNull
//    private Long reportResidentId;

    @NotNull
    private LocalDate reportDate;

//    @NotNull
//    private BirthReportQualificationsCode birthReportQualifications;

    @NotNull
    private DeathReportQualificationsCode deathReportQualifications;

    @Email
    private String emailAddress;

    @NotBlank
    private String phoneNumber;

}
