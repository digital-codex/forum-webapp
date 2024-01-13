package dev.digitalcodex.web.persistence.repository;

import dev.digitalcodex.web.persistence.PersistenceConstants;
import dev.digitalcodex.web.persistence.entity.VoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(PersistenceConstants.VOTE_REPOSITORY_BEAN_NAME)
public interface VoteRepository extends JpaRepository<VoteEntity, Long> {
}