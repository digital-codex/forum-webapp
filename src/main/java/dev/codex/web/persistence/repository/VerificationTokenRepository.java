package dev.codex.web.persistence.repository;

import dev.codex.web.persistence.PersistenceConstants;
import dev.codex.web.persistence.entity.VerificationTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository(PersistenceConstants.VERIFICATION_TOKEN_REPOSITORY_BEAN_NAME)
public interface VerificationTokenRepository extends JpaRepository<VerificationTokenEntity, Long> {
    @Query(
            "SELECT t.insertedBy FROM VerificationTokenEntity t WHERE t.token = :token AND t.expiresAt > CURRENT_TIMESTAMP"
    )
    Optional<Long> findInsertedByByToken(@Param("token") String token);
}