package com.nhnacademy.jpa.entity;

import com.nhnacademy.jpa.domain.BirthReportModifyRequest;
import com.nhnacademy.jpa.domain.DeathReportModifyRequest;
import com.nhnacademy.jpa.enums.BirthDeathTypeCode;
import com.nhnacademy.jpa.enums.BirthReportQualificationsCode;
import com.nhnacademy.jpa.enums.DeathReportQualificationsCode;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/*
create table birth_death_report_resident
(
   resident_serial_number           int(11)     not null, o
   birth_death_type_code            varchar(20) not null, o
   report_resident_serial_number    int(11)     not null, o
   birth_death_report_date          date        not null,
   birth_report_qualifications_code varchar(20) null,
   death_report_qualifications_code varchar(20) null,
   email_address                    varchar(50) null,
   phone_number                     varchar(20) not null,
   primary key (resident_serial_number, birth_death_type_code)
);

출생사망신고주민 테이블
PK: resident_serial_number(피신고자), birth_death_type_code
FK: report_resident_serial_number(신고자)

 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "birth_death_report_resident")
public class BirthDeathReportResident {
    @EmbeddedId
    private Pk pk;

    @MapsId("targetResidentId")
    @ManyToOne
    @JoinColumn(name = "resident_serial_number")
    private Resident targetResident;

    @ManyToOne
    @JoinColumn(name = "report_resident_serial_number")
    private Resident reportResident;

    @Column(name = "birth_death_report_date")
    private LocalDate reportDate;

    @Column(name = "birth_report_qualifications_code")
    @Enumerated(EnumType.STRING)
    private BirthReportQualificationsCode birthReportQualifications;

    @Column(name = "death_report_qualifications_code")
    @Enumerated(EnumType.STRING)
    private DeathReportQualificationsCode deathReportQualifications;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Embeddable
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class Pk implements Serializable {
        @Column(name = "resident_serial_number")
        private Long targetResidentId;

        @Column(name = "birth_death_type_code")
        @Enumerated(EnumType.STRING)
        private BirthDeathTypeCode birthDeathType;
    }

    public void modifyBirthReport(BirthReportModifyRequest request) {
        if (!Objects.isNull(request.getReportDate())) {
            this.reportDate = request.getReportDate();
        }

        if (!Objects.isNull(request.getBirthReportQualifications())) {
            this.birthReportQualifications = request.getBirthReportQualifications();
        }

        if (!Objects.isNull(request.getEmailAddress())) {
            this.emailAddress = request.getEmailAddress();
        }

        if (!Objects.isNull(request.getPhoneNumber())) {
            this.phoneNumber = request.getPhoneNumber();
        }
    }

    public void modifyDeathReport(DeathReportModifyRequest request) {
        if (!Objects.isNull(request.getReportDate())) {
            this.reportDate = request.getReportDate();
        }

        if (!Objects.isNull(request.getDeathReportQualifications())) {
            this.deathReportQualifications = request.getDeathReportQualifications();
        }

        if (!Objects.isNull(request.getEmailAddress())) {
            this.emailAddress = request.getEmailAddress();
        }

        if (!Objects.isNull(request.getPhoneNumber())) {
            this.phoneNumber = request.getPhoneNumber();
        }
    }
}
