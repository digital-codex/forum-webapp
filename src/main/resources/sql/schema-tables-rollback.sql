-- ROLLBACK
-- s_forum.t_comment foreign keys rollback
ALTER TABLE IF EXISTS s_forum.t_comment DROP CONSTRAINT IF EXISTS t_comment_inserted_by_fk;
ALTER TABLE IF EXISTS s_forum.t_comment DROP CONSTRAINT IF EXISTS t_comment_post_id_fk;

-- s_forum.t_comment definition rollback

DROP TABLE IF EXISTS s_forum.t_comment;

-- s_forum.t_vote foreign keys

ALTER TABLE IF EXISTS s_forum.t_vote DROP CONSTRAINT IF EXISTS t_vote_post_id_vote_type_inserted_by_unq;
ALTER TABLE IF EXISTS s_forum.t_vote DROP CONSTRAINT IF EXISTS t_vote_inserted_by_fk;
ALTER TABLE IF EXISTS s_forum.t_vote DROP CONSTRAINT IF EXISTS t_vote_post_id_fk;

-- s_forum.t_vote definition rollback

DROP TABLE IF EXISTS s_forum.t_vote;

-- s_forum.t_post_description foreign keys rollback

ALTER TABLE IF EXISTS s_forum.t_post_description DROP CONSTRAINT IF EXISTS t_post_description_inserted_by_fk;
ALTER TABLE IF EXISTS s_forum.t_post_description DROP CONSTRAINT IF EXISTS t_post_description_shared_id_fk;

-- s_forum.t_post_description definition rollback

DROP TABLE IF EXISTS s_forum.t_post_description;

-- s_forum.t_post foreign keys rollback

ALTER TABLE IF EXISTS s_forum.t_post DROP CONSTRAINT IF EXISTS t_post_inserted_by_fk;
ALTER TABLE IF EXISTS s_forum.t_post DROP CONSTRAINT IF EXISTS t_post_forum_id_fk;

-- s_forum.t_post definition rollback

DROP TABLE IF EXISTS s_forum.t_post;

-- s_forum.t_forum foreign keys rollback

ALTER TABLE IF EXISTS s_forum.t_forum DROP CONSTRAINT IF EXISTS t_forum_inserted_by_fk;

-- s_forum.t_forum definition rollback

DROP TABLE IF EXISTS s_forum.t_forum;

-- s_forum.t_refresh_token foreign keys rollback

ALTER TABLE IF EXISTS s_forum.t_refresh_token DROP CONSTRAINT IF EXISTS t_refresh_token_inserted_by_fk;

-- s_forum.t_refresh_token definition rollback

DROP TABLE IF EXISTS s_forum.t_refresh_token;

-- s_forum.t_verification_token foreign keys rollback

ALTER TABLE IF EXISTS s_forum.t_verification_token DROP CONSTRAINT IF EXISTS t_verification_token_inserted_by_fk;

-- s_forum.t_verification_token definition rollback

DROP TABLE IF EXISTS s_forum.t_verification_token;

-- s_forum.t_user definition

DROP TABLE IF EXISTS s_forum.t_user;