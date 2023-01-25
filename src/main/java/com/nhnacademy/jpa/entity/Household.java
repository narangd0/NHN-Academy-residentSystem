package com.nhnacademy.jpa.entity;

import com.nhnacademy.jpa.enums.HouseholdCompositionReasonCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Household {
    @Id
    @Column(name = "household_serial_number")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "household_resident_serial_number")
    private Resident householder;

    @Column(name = "household_composition_date")
    private LocalDateTime compositionDate;

    @Column(name = "household_composition_reason_code")
    @Enumerated(EnumType.STRING)
    private HouseholdCompositionReasonCode householdCompositionReason;

    @Column(name = "current_house_movement_address")
    private String address;
}
