--liquibase formatted sql
--changeset IvanZhuravlev:create-players-table
CREATE TABLE IF NOT EXISTS players
(
    id bigint NOT NULL AUTO_INCREMENT,
    first_name character varying(256) NOT NULL,
    last_name character varying(256) NOT NULL,
    age INT NOT NULL,
    experience decimal(10,2) NOT NULL,
    date_of_birth DATE NOT NULL,
    country_of_birth character varying(256) NOT NULL,

    CONSTRAINT player_pk PRIMARY KEY(id)
    );

--rollback DROP TABLE players;
