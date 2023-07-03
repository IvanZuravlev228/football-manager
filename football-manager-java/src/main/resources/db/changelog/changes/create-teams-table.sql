--liquibase formatted sql
--changeset IvanZhuravlev:create-teams-table
CREATE TABLE IF NOT EXISTS teams
(
    id bigint NOT NULL AUTO_INCREMENT,
    team_name character varying(256) NOT NULL,
    country character varying(256) NOT NULL,
    nickname character varying(256) NOT NULL,
    money decimal(10,2) NOT NULL,
    commission decimal(10,2) NOT NULL,

    CONSTRAINT team_pk PRIMARY KEY(id)
    );

--rollback DROP TABLE teams;