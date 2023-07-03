package com.example.footballmanager.service;

public interface TransferService {
    void moveToOtherTeam(Long fromTeamId, Long toTeamId, Long playerId);
}
