package com.wb.authservice.service;

import com.wb.authservice.model.dto.ApplicationUserDto;
import com.wb.authservice.model.entity.ApplicationUser;


public interface AuthService {
    ApplicationUserDto login(ApplicationUser user);
}
