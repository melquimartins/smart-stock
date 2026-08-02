package io.github.melquimartins.smartstock.shared.exception;

import org.springframework.security.core.AuthenticationException;

public class UnauthorizedException extends AuthenticationException {

    private static final String DEFAULT_MESSAGE =
            "Acesso negado. É necessário estar autenticado para acessar este recurso.";

    public UnauthorizedException() {
        super(DEFAULT_MESSAGE);
    }

    public UnauthorizedException(String message) {
        super(message);
    }

}
