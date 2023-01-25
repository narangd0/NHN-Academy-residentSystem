package com.nhnacademy.jpa.entity;

import com.nhnacademy.jpa.domain.ResidentModifyRequest;
import com.nhnacademy.jpa.enums.BirthPlaceCode;
import com.nhnacademy.jpa.enums.DeathPlaceCode;
import com.nhnacademy.jpa.enums.GenderCode;
import lombok.*;

import javax.persistence.*;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "resident")
public class Resident {
    @Id
    @Column(name = "resident_serial_number")
    private Long id;

    @Column
    private String name;

    /**
     * 주민등록번호
     */
    @Column(name = "resident_registration_number")
    private String registrationNumber;

    @Column(name = "gender_code")
    @Enumerated(EnumType.STRING)
    private GenderCode gender;

    @Column(name = "birth_date")
    private LocalDateTime birthDate;

    @Column(name = "birth_place_code")
    @Enumerated(EnumType.STRING)
    private BirthPlaceCode birthPlace;

    @Column(name = "registration_base_address")
    private String registrationBaseAddress;

    @Column(name = "death_date")
    private LocalDateTime deathDate;

    @Column(name = "death_place_code")
    @Enumerated(EnumType.STRING)
    private DeathPlaceCode deathPlace;

    @Column(name = "death_place_address")
    private String deathPlaceAddress;

    public void modify(ResidentModifyRequest request) {
        Field[] requestFields = request.getClass().getDeclaredFields();
        int i = 0;
        try {
            for (Field declaredField : this.getClass().getDeclaredFields()) {
                requestFields[i].setAccessible(true);
                if (!Objects.isNull(requestFields[i].get(request))) {
                    declaredField.setAccessible(true);
                    declaredField.set(this, requestFields[i].get(request));
                }
                i++;
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
