package com.nhnacademy.jpa.entity;

import com.nhnacademy.jpa.enums.CertificateTypeCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

/*
create table certificate_issue
(
   certificate_confirmation_number bigint      not null,
   resident_serial_number          int         not null,
   certificate_type_code           varchar(20) not null,
   certificate_issue_date          date        not null,
   primary key (certificate_confirmation_number)
);
 */
@Entity
@Getter
@Setter
@Table(name = "certificate_issue")
public class CertificateIssue {
    @Id
    @Column(name = "certificate_confirmation_number")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "resident_serial_number")
    private Resident resident;

    @Column(name = "certificate_type_code")
    @Enumerated(EnumType.STRING)
    private CertificateTypeCode certificateType;

    @Column(name = "certificate_issue_date")
    private LocalDate issueDate;
}
