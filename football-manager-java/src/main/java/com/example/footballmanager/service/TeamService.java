package com.example.footballmanager.service;

import com.example.footballmanager.model.Player;
import com.example.footballmanager.model.Team;
import java.util.List;

public interface TeamService {
    Team getById(Long id);

    List<Team> getAllTeams();

    Team createTeam(Team team);

    Team addPlayerToTeam(Long teamId, Long playerId);

    Team update(Team team);

    void delete(Long id);

    List<Player> getAllPlayersByTeamId(Long teamId);
}
