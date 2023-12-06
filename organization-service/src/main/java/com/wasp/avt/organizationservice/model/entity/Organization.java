package com.wasp.avt.organizationservice.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Organization implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "timestamp default current_timestamp")
    private LocalDateTime createdAt;

    @Column(columnDefinition = "timestamp")
    private LocalDateTime lastModifiedAt;

    private int totalModified = 0;

    @NotEmpty(message = "The field 'name' cannot be empty")
    @Column(nullable = false, unique = true)
    private String name;

    private String description;

    @NotEmpty(message = "The field 'nif' cannot be empty")
    @Column(nullable = false, unique = true)
    private String nif;

    @Email(message = "The given 'email' is not valid")
    @NotEmpty(message = "The field 'email' cannot be empty")
    @Column(nullable = false, unique = true)
    private String email;

    @NotEmpty(message = "The field 'code' cannot be empty")
    @Column(nullable = false, unique = true)
    private String code;
}
