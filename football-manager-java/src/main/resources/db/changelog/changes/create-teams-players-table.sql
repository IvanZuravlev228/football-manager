--liquibase formatted sql
--changeset IvanZhuravlev:create-teams-players-table
CREATE TABLE IF NOT EXISTS teams_players
(
    team_id bigint NOT NULL,
    player_id bigint NOT NULL,

    FOREIGN KEY (team_id) REFERENCES teams (id),
    FOREIGN KEY (player_id) REFERENCES players (id)
    );

--rollback DROP TABLE teams_players;