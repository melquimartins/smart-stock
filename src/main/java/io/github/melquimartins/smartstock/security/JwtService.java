package io.github.melquimartins.smartstock.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import io.github.melquimartins.smartstock.shared.exception.UnauthorizedException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class JwtService {

    private final Algorithm algorithm;

    public JwtService(@Value("teste123") String secret) {
        if (secret == null || secret.isBlank()) {
            throw new IllegalStateException("JWT_SECRET não configurado.");
        }

        this.algorithm = Algorithm.HMAC256(secret);
    }

    public String generateToken(String subject, Instant expiresAt) {
        return JWT
                .create()
                .withSubject(subject)
                .withExpiresAt(expiresAt)
                .sign(algorithm);
    }

    public String validateToken(String token) {
        try {
            if (token == null || token.isBlank()) {
                throw new UnauthorizedException();
            }

            return JWT
                    .require(algorithm)
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            throw new UnauthorizedException();
        }
    }

}
