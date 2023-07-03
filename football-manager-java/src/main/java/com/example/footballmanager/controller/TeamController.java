package com.example.footballmanager.controller;

import com.example.footballmanager.dto.player.PlayerResponseDto;
import com.example.footballmanager.dto.team.TeamRequestDto;
import com.example.footballmanager.dto.team.TeamResponseDto;
import com.example.footballmanager.service.TeamService;
import com.example.footballmanager.service.mapper.PlayerMapper;
import com.example.footballmanager.service.mapper.TeamMapper;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/teams")
public class TeamController {
    private final TeamService teamService;
    private final TeamMapper teamMapper;
    private final PlayerMapper playerMapper;

    @PostMapping
    public TeamResponseDto createTeam(@RequestBody TeamRequestDto dto) {
        System.out.println("Create team. DTO: " + dto);
        return teamMapper.toDto(teamService.createTeam(teamMapper.toModel(dto)));
    }

    @PostMapping("/add")
    public TeamResponseDto addPlayer(@RequestParam Long teamId,
                                     @RequestParam Long playerId) {
        System.out.println("Add player by id: " + playerId + " to team by id: " + teamId);
        return teamMapper.toDto(teamService.addPlayerToTeam(teamId, playerId));
    }

    @GetMapping("/{id}")
    public TeamResponseDto getById(@PathVariable Long id) {
        System.out.println("Get team by id: " + id);
        return teamMapper.toDto(teamService.getById(id));
    }

    @GetMapping
    public List<TeamResponseDto> getAll() {
        System.out.println("Get all teams");
        return teamService.getAllTeams().stream()
                .map(teamMapper::toDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        System.out.println("Delete team by id: " + id);
        teamService.delete(id);
    }

    @GetMapping("/players/{id}")
    public List<PlayerResponseDto> getAllPlayers(@PathVariable Long id) {
        System.out.println("Get all players by team id: " + id);
        return teamService.getAllPlayersByTeamId(id).stream()
                .map(playerMapper::toDto)
                .collect(Collectors.toList());
    }
}
