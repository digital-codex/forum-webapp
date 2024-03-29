package dev.codex.web.application.service;

import dev.codex.web.application.ApplicationConstants;
import dev.codex.web.application.exception.ProcessingException;
import dev.codex.web.persistence.entity.VerificationTokenEntity;
import dev.codex.web.persistence.repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Service(ApplicationConstants.VERIFICATION_TOKEN_SERVICE_BEAN_NAME)
public class VerificationTokenService {
    private final VerificationTokenRepository repository;

    @Autowired
    public VerificationTokenService(VerificationTokenRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public String generate(Long userId) {
        if (userId == null)
            throw new ProcessingException(ProcessingException.NULL_POINTER_EXCEPTION_MSG_FORMAT.formatted("userId"));

        VerificationTokenEntity persisted = this.repository.save(VerificationTokenEntity.builder()
                .token(UUID.randomUUID().toString())
                .expiresAt(Instant.now().plus(8, ChronoUnit.HOURS))
                .insertedBy(userId)
                .insertedAt(Instant.now())
                .build()
        );

        return persisted.getToken();
    }

    @Transactional(readOnly = true)
    public Long loadUserEntityIdByToken(String token) {
        return this.repository.findInsertedByByToken(token)
                .orElseThrow(
                        () -> new ProcessingException(ProcessingException.RESOURCE_NOT_FOUND_EXCEPTION_MSG_FORMAT.formatted(VerificationTokenEntity.class.getSimpleName()))
                );
    }
}