package com.wb.authservice.security.filter;

import java.util.concurrent.TimeUnit;

public final class SecurityConstants {
    public static final String SECRET = "2020SecretKeyFromLitroft20190512SecretKeyFromLitroft20190512SecretKeyFromLitroft20190512SecretKeyFromLitroft20190512";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String HEADER_AGENT = "User-Agent";
    public static final Long EXPIRATION_TIME = TimeUnit.DAYS.toMillis(7);

    public static final String HEADER_VALUE_STRING = "attachment";

    private SecurityConstants() {
    }
}
