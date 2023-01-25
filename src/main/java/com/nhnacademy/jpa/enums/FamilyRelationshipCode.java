package com.nhnacademy.jpa.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum FamilyRelationshipCode {
    본인,
    부,
    모,
    배우자,
    자녀,
    형제

    /*본인("본인"),
    부("부"),
    모("모"),
    배우자("배우자"),
    자녀("자녀"),
    형제("형제");

    private String value;

    FamilyRelationshipCode(String value) {
        this.value = value;
    }

    @JsonCreator
    public static FamilyRelationshipCode from(String value) {
        for (FamilyRelationshipCode code : FamilyRelationshipCode.values()) {
            if (code.getValue().equals(value)) {
//            if (code.equals(value)) {
                return code;
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }*/
}
