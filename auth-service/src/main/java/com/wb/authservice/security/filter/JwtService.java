package com.wb.authservice.security.filter;

import com.wb.authservice.model.entity.ApplicationUser;
import com.wb.authservice.security.permission.models.CustomPermission;
import com.wb.authservice.security.permission.models.CustomRole;
import com.wb.authservice.util.AuthenticatedUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Log4j2
@Service
public class JwtService {

    private static final String ROLE = "ROLE_";
    private final ZonedDateTime expirationTimeUTC = ZonedDateTime.now(ZoneOffset.UTC)
            .plus(SecurityConstants.EXPIRATION_TIME,
                    ChronoUnit.MILLIS);

    @Value("${spring.application.security.jwt.secret-key}")
    private String secretKey;
    @Value("${spring.application.security.jwt.expiration}")
    private long jwtExpiration;
    @Value("${spring.application.security.jwt.refresh-token.expiration}")
    private long refreshExpiration;

    static AuthenticatedUser authUser(ApplicationUser user) {
        AuthenticatedUser authUser = new AuthenticatedUser();

//        if (user.getAdminEntity() != null)
//            authUser = user.getAdminEntity().toAuthUser();
//        if (user.getFuncionario() != null)
//            authUser = user.getFuncionario().toAuthUser();
//        if (user.getPessoaContato() != null)
//            authUser = user.getPessoaContato().toAuthUser();

        authUser.setAccountId(user.getId());
        authUser.setUsername(user.getUsername());
        authUser.setTheme(user.getTheme());

        return authUser;
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String generateToken(ApplicationUser userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    public String generateToken(
            Map<String, Object> extraClaims,
            ApplicationUser userDetails) {
        return buildToken(extraClaims, userDetails, jwtExpiration);
    }

    public String generateRefreshToken(
            ApplicationUser userDetails) {
        return buildToken(new HashMap<>(), userDetails, refreshExpiration);
    }

    private String buildToken(
            Map<String, Object> extraClaims,
            ApplicationUser user,
            long expiration) {

        // ApplicationUser userApp = principal.getUser();

        var authUser = authUser(user);

        // COMMENT:Mapping all roles to a List of Roles
        authUser.setRoles(user.getRoles()
                .stream()
                .map(CustomRole::getNome)
                .takeWhile(e -> e.startsWith(ROLE))
                .collect(Collectors.toList()));

        // COMMENT:Mapping all permissions to a List of Permissions
        authUser.setPermissions(user.getPermissions()
                .stream()
                .map(CustomPermission::getNome)
                .takeWhile(e -> !e.contains(ROLE))
                .collect(Collectors.toList()));

        String token = Jwts.builder()
                .setSubject(user.getUsername())
                .setClaims(extraClaims)
                .setSubject(user.getUsername())

                .claim("authorities", user.getRoles())
                .claim("permissions", user.getPermissions())
                .claim("accountId", authUser.getAccountId())
                .claim("userId", authUser.getUserId())

                .setIssuedAt(new Date())
                .setExpiration(Date.from(expirationTimeUTC.toInstant()))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .setHeaderParam("typ", "JWT")
                .compact();

        return SecurityConstants.TOKEN_PREFIX + token;
    }

    public boolean isTokenValid(@NonNull String token, @NonNull ApplicationUser userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date(System.currentTimeMillis()));
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    @NonNull
    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
