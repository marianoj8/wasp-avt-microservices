package com.wasp.avt.authservice.security.permission.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
public class CustomPermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "timestamp default current_timestamp")
    private LocalDateTime createdAt;

    @Column(columnDefinition = "timestamp")
    private LocalDateTime lastModifiedAt;

    private int totalModified = 0;

    @Column(unique = true)
    private String nome;

    public CustomPermission(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}
