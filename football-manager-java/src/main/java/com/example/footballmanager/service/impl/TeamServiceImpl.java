package com.example.footballmanager.service.impl;

import com.example.footballmanager.model.Player;
import com.example.footballmanager.model.Team;
import com.example.footballmanager.repository.TeamRepository;
import com.example.footballmanager.service.PlayerService;
import com.example.footballmanager.service.TeamService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;
    private final PlayerService playerService;

    @Override
    public Team getById(Long id) {
        return teamRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Can't find team by id: " + id));
    }

    @Override
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @Override
    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public Team addPlayerToTeam(Long teamId, Long playerId) {
        Team team = getById(teamId);
        team.getPlayers().add(playerService.getById(playerId));
        return teamRepository.save(team);
    }

    @Override
    public Team update(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public void delete(Long id) {
        teamRepository.deleteById(id);
    }

    @Override
    public List<Player> getAllPlayersByTeamId(Long teamId) {
        return getById(teamId).getPlayers();
    }
}
