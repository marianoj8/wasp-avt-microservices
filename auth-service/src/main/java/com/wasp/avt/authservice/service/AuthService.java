package com.wasp.avt.authservice.service;

import com.wasp.avt.authservice.model.dto.ApplicationUserDto;
import com.wasp.avt.authservice.model.entity.ApplicationUser;


public interface AuthService {
    ApplicationUserDto login(ApplicationUser user);
}
