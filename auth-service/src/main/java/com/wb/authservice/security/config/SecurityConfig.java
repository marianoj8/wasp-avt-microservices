package com.wb.authservice.security.config;

import com.wb.authservice.security.filter.JwtAuthenticationFilterV3;
import com.wb.authservice.security.filter.SecurityConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.web.cors.CorsConfiguration;

import java.time.Duration;
import java.util.List;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private static final String[] WHITE_LIST_URL = {
            "/logistics/**",
            "/v1/logistics/**",
            "/v1/auth/**",
            "/v2/api-docs",
            "/v3/api-docs",
            "/v3/api-docs/**",
            "/actuator/**",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui/**",
            "/webjars/**",
            "/swagger-ui.html"};

    private static final String ACCES_CONTROL_ALLOW_OGIGIN = "Access-Control-Allow-Origin";

    private final AuthenticationProvider authenticationProvider;
    private final JwtAuthenticationFilterV3 jwtAuthFilter3;
    private final LogoutHandler logoutHandler;

    @Value("${spring.host1}")
    private String host1;
    @Value("${spring.host2}")
    private String host2;
    @Value("${spring.host3}")
    private String host3;
    @Value("${spring.host4}")
    private String host4;
    @Value("${spring.host5}")
    private String host5;
    @Value("${spring.host6}")
    private String host6;
    @Value("${spring.host7}")
    private String host7;
    @Value("${spring.host8}")
    private String host8;
    @Value("${spring.host9}")
    private String host9;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .cors((cs) -> cs.configurationSource(request -> new CorsConfiguration(getCorsConfiguration())))
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(req ->
                        req.requestMatchers(WHITE_LIST_URL)
                                .permitAll()
                                .anyRequest()
                                .authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter3, UsernamePasswordAuthenticationFilter.class)
                .logout(logout ->
                        logout.logoutUrl("/v1/auth/logout")
                                .addLogoutHandler(logoutHandler)
                                .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext())
                );

        return http.build();
    }

    private CorsConfiguration getCorsConfiguration() {
        var corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOrigins(List.of(host1, host2, host3, host4, host5, host6, host7, host8, host9));
        corsConfiguration.setAllowedHeaders(List.of("Origin", ACCES_CONTROL_ALLOW_OGIGIN, "Content-Type",
                "Accept", SecurityConstants.HEADER_STRING, "Origin, Accept", "X-Requested-With", "X-XSRF-TOKEN",
                "Access-Control-Request-Method", "Access-Control-Request-Headers"));
        corsConfiguration.setExposedHeaders(List.of("Origin", "Content-Type", "Accept", "Authorization", "X-XSRF-TOKEN",
                ACCES_CONTROL_ALLOW_OGIGIN, ACCES_CONTROL_ALLOW_OGIGIN, ACCES_CONTROL_ALLOW_OGIGIN));
        corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        corsConfiguration.setMaxAge(Duration.ofDays(7));
        return corsConfiguration;
    }
}
