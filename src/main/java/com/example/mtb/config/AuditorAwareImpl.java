package com.example.mtb.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component //auditorAwareImpl
public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        String username = Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
                .map( auth -> auth.getName() )
                .orElse("System");

        return Optional.of(username);
    }

}