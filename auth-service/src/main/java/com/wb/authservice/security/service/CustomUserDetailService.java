package com.wb.authservice.security.service;

import com.wb.authservice.repository.ApplicationUserRepository;
import com.wb.authservice.security.permission.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CustomUserDetailService implements UserDetailsService {

    private final ApplicationUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = Optional.ofNullable(userRepository.findByUsername(username))
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with username %s not found", username)));

        return new UserPrincipal(user); //UserPrincipal precisa ser customizando com objeto ApplicationUser
    }
}
