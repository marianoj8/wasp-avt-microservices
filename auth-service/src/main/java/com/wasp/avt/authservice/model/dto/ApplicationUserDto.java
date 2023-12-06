package com.wasp.avt.authservice.model.dto;

import com.wasp.avt.authservice.security.permission.models.CustomPermission;
import com.wasp.avt.authservice.security.permission.models.CustomRole;
import com.wasp.avt.authservice.util.Themes;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotEmpty;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.time.LocalDateTime;
import java.util.Collection;

public record ApplicationUserDto(
        Long id,
        @Column(columnDefinition = "timestamp default current_timestamp")
        LocalDateTime createdAt,
        @Column(columnDefinition = "timestamp")
        LocalDateTime lastModifiedAt,
        int totalModified,
        @NotEmpty(message = "The field 'username' cannot be empty")
        @Column(nullable = false, unique = true)
        String username,
        @ToString.Exclude
        String password,
        @Column(columnDefinition = "Text")
        String accessToken,
        @Column(columnDefinition = "Text")
        String refreshToken,
        Themes theme,
        @ManyToMany(fetch = FetchType.EAGER)
        Collection<CustomRole> roles,
        @ManyToMany(fetch = FetchType.EAGER)
        @Fetch(value = FetchMode.SUBSELECT)
        Collection<CustomPermission> permissions,
        boolean isAccountNonExpired,
        boolean isAccountNonLocked,
        boolean isCredentialsNonExpired) {
}
