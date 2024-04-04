package com.wb.employeeservice.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "timestamp default current_timestamp")
    private LocalDateTime createdAt;

    @Column(columnDefinition = "timestamp")
    private LocalDateTime lastModifiedAt;

    private int totalModified = 0;

    @NotEmpty(message = "The field 'firstName' cannot be empty")
    private String firstName;

    @NotEmpty(message = "The field 'lastName' cannot be empty")
    private String lastName;

    private Gender gender = Gender.M;

    @NotEmpty(message = "The field 'email' cannot be empty")
    @Email(message = "Given email is not valid")
    @Column(nullable = false, unique = true)
    private String email;

    @NotNull(message = "The field 'departmentId' cannot be null")
    @Column(nullable = false)
    private Long departmentId;

    @NotNull(message = "The field 'organizationId' cannot be null")
    @Column(nullable = false)
    private Long organizationId;
}
