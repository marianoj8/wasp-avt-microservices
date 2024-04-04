package com.wb.departmentservice.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "timestamp default current_timestamp")
    private LocalDateTime createdAt;

    @Column(columnDefinition = "timestamp")
    private LocalDateTime lastModifiedAt;

    private int totalModified = 0;

    @NotEmpty(message = "The field 'name' cannot be empty")
    @Column(nullable = false)
    private String name;

    private String description;

    @NotEmpty(message = "The field 'code' cannot be empty")
    @Column(unique = true, nullable = false)
    private String code;
}
