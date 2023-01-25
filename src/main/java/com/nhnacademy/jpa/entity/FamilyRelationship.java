package com.nhnacademy.jpa.entity;

import com.nhnacademy.jpa.enums.FamilyRelationshipCode;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
//@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "family_relationship")
public class FamilyRelationship {
    @EmbeddedId
    private Pk pk;

    @MapsId("baseResidentId")
    @ManyToOne
    @JoinColumn(name = "base_resident_serial_number")
    private Resident baseResident;

//    @MapsId("familyResidentId")
//    @ManyToOne
//    @JoinColumn(name = "family_resident_serial_number")
//    private Resident familyResident;

    @Column(name = "family_relationship_code")
    @Enumerated(EnumType.STRING)
    private FamilyRelationshipCode relationship;

    @NoArgsConstructor
    @EqualsAndHashCode
    @Getter
    @Setter
    @Embeddable
    @AllArgsConstructor
    public static class Pk implements Serializable {
        @Column(name = "base_resident_serial_number")
        private Long baseResidentId;

        @Column(name = "family_resident_serial_number")
        private Long familyResidentId;
    }
}
