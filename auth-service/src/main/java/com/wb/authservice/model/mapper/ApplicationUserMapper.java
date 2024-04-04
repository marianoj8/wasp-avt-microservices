package com.wb.authservice.model.mapper;

import com.wb.authservice.model.dto.ApplicationUserDto;
import com.wb.authservice.model.entity.ApplicationUser;

public class ApplicationUserMapper {
    public static ApplicationUserDto modelToDto(ApplicationUser model) {
        return model == null ? null : new ApplicationUserDto(
                model.getId(),
                model.getCreatedAt(),
                model.getLastModifiedAt(),
                model.getTotalModified(),
                model.getUsername(),
                model.getPassword(),
                model.getAccessToken(),
                model.getRefreshToken(),
                model.getTheme(),
                model.getRoles(),
                model.getPermissions(),
                model.isAccountNonExpired(),
                model.isAccountNonLocked(),
                model.isCredentialsNonExpired());
    }

    public static ApplicationUser dtoToModel(ApplicationUserDto dto) {
        return dto == null ? null : new ApplicationUser(
                dto.id(),
                dto.createdAt(),
                dto.lastModifiedAt(),
                dto.totalModified(),
                dto.username(),
                dto.password(),
                dto.accessToken(),
                dto.refreshToken(),
                dto.roles(),
                dto.permissions(),
                dto.theme(),
                dto.isAccountNonExpired(),
                dto.isAccountNonLocked(),
                dto.isCredentialsNonExpired());
    }
}
