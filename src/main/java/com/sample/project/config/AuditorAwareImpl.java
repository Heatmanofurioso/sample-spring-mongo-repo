package com.sample.project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuditorAwareImpl implements AuditorAware<String> {

    private final String applicationName;

    @Autowired
    public AuditorAwareImpl(@Value("${spring.application.name:system}") String applicationName) {
        this.applicationName = applicationName;
    }

    @Override
    public Optional<String> getCurrentAuditor() {

        Authentication authentication = SecurityContextHolder
            .getContext()
            .getAuthentication();
        String uname = applicationName;
        if (authentication != null) {
            uname = authentication
                .getName();
        }
        return Optional.of(uname);
    }
}
