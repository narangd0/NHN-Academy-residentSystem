package com.nhnacademy.jpa.entity;

import com.nhnacademy.jpa.enums.HouseholdCompositionChangeReasonCode;
import com.nhnacademy.jpa.enums.HouseholdRelationshipCode;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/*
create table household_composition_resident
(
   household_serial_number                  int(11)     not null,
   resident_serial_number                   int(11)     not null,
   report_date                              date        not null,
   household_relationship_code              varchar(20) not null,
   household_composition_change_reason_code varchar(20) not null,
   primary key (household_serial_number, resident_serial_number)
);
 */

@Entity
@Table(name = "household_composition_resident")
public class HouseholdCompositionResident {
    @EmbeddedId
    private Pk pk;

    @MapsId("householdId")
    @ManyToOne
    @JoinColumn(name = "household_serial_number")
    private Household household;

    @MapsId("residentId")
    @ManyToOne
    @JoinColumn(name = "resident_serial_number")
    private Resident resident;

    @Column(name = "report_date")
    private LocalDate reportDate;

    @Column(name = "household_relationship_code")
    @Enumerated(EnumType.STRING)
    private HouseholdRelationshipCode householdRelationship;

    @Column(name = "household_composition_change_reason_code")
    @Enumerated(EnumType.STRING)
    private HouseholdCompositionChangeReasonCode householdCompositionChangeReason;

    @Embeddable
    @NoArgsConstructor
    @EqualsAndHashCode
    public static class Pk implements Serializable {
        @Column(name = "household_serial_number")
        private Long householdId;

        @Column(name = "resident_serial_number")
        private Long residentId;
    }
}
