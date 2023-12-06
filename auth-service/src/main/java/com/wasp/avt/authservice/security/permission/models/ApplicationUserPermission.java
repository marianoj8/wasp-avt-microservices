package com.wasp.avt.authservice.security.permission.models;

import com.wasp.avt.authservice.model.entity.ApplicationUser;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "ApplicationUser_permissions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
public class ApplicationUserPermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "timestamp default current_timestamp")
    private LocalDateTime createdAt;

    @Column(columnDefinition = "timestamp")
    private LocalDateTime lastModifiedAt;

    private int totalModified = 0;

    @ManyToOne(targetEntity = ApplicationUser.class)
    private ApplicationUser applicationUser;

    @ManyToOne(targetEntity = CustomPermission.class)
    private CustomPermission permissions;
}
