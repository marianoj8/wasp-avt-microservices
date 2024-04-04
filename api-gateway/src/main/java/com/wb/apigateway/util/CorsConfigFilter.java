package com.wb.apigateway.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.time.Duration;
import java.util.List;

@RefreshScope
@Configuration
public class CorsConfigFilter {

    private static final String ACCES_CONTROL_ALLOW_OGIGIN = "Access-Control-Allow-Origin";
    @Value("${spring.host1}")
    private String host1;
    @Value("${spring.host2}")
    private String host2;
    @Value("${spring.host3}")
    private String host3;

    @Bean
    public CorsWebFilter corsFilter() {

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", getCorsConfiguration());

        return new CorsWebFilter(source);
    }

    private CorsConfiguration getCorsConfiguration() {
        var corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOrigins(List.of(host1, host2, host3));
        corsConfiguration.setAllowedHeaders(List.of("Origin", ACCES_CONTROL_ALLOW_OGIGIN, "Content-Type",
                "Accept", "Authorization", "Origin, Accept", "X-Requested-With", "X-XSRF-TOKEN",
                "Access-Control-Request-Method", "Access-Control-Request-Headers"));
        corsConfiguration.setExposedHeaders(List.of("Origin", "Content-Type", "Accept", "Authorization", "X-XSRF-TOKEN",
                ACCES_CONTROL_ALLOW_OGIGIN, ACCES_CONTROL_ALLOW_OGIGIN, ACCES_CONTROL_ALLOW_OGIGIN));
        corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        corsConfiguration.setMaxAge(Duration.ofDays(7));
        return corsConfiguration;
    }
}
