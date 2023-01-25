package com.nhnacademy.jpa.entity;

import com.nhnacademy.jpa.enums.LastAddressYN;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "household_movement_address")
public class HouseholdMovementAddress {
    @EmbeddedId
    private Pk pk;

    @MapsId("householderId")
    @ManyToOne
    @JoinColumn(name = "household_serial_number")
    private Household household;

    @Column(name = "house_movement_address")
    private String address;

    @Column(name = "last_address_yn")
    @Enumerated(EnumType.STRING)
    private LastAddressYN lastAddressYN;

    @NoArgsConstructor
    @EqualsAndHashCode
    @Getter
    @Setter
    @Embeddable
    public static class Pk implements Serializable {
        @Column(name = "house_movement_report_date")
        private LocalDate reportDate;

        @Column(name = "household_serial_number")
        private Long householderId;
    }
}
