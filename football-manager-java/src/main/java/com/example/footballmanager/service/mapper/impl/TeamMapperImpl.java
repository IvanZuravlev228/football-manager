package com.example.footballmanager.service.mapper.impl;

import com.example.footballmanager.dto.team.TeamRequestDto;
import com.example.footballmanager.dto.team.TeamResponseDto;
import com.example.footballmanager.model.Player;
import com.example.footballmanager.model.Team;
import com.example.footballmanager.service.PlayerService;
import com.example.footballmanager.service.mapper.TeamMapper;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TeamMapperImpl implements TeamMapper {
    private final PlayerService playerService;

    @Override
    public TeamResponseDto toDto(Team team) {
        TeamResponseDto dto = new TeamResponseDto();
        dto.setMoney(team.getMoney());
        dto.setId(team.getId());
        dto.setPlayersId(team.getPlayers().stream()
                .map(Player::getId)
                .collect(Collectors.toList()));
        dto.setCommission(team.getCommission());
        dto.setNickname(team.getNickname());
        dto.setTeamName(team.getTeamName());
        dto.setCountry(team.getCountry());
        return dto;
    }

    @Override
    public Team toModel(TeamRequestDto dto) {
        Team team = new Team();
        team.setMoney(dto.getMoney());
        team.setTeamName(dto.getTeamName());
        team.setPlayers(dto.getPlayersId().stream()
                .map(playerService::getById)
                .collect(Collectors.toList()));
        team.setNickname(dto.getNickname());
        team.setCountry(dto.getCountry());
        team.setCommission(dto.getCommission());
        return team;
    }
}
