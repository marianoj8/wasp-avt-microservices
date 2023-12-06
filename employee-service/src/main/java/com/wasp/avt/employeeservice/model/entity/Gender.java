package com.wasp.avt.employeeservice.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Gender {
    M("M"),
    F("F");
    final String gender;
}
