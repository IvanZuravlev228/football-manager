package com.example.footballmanager.service.mapper;

import com.example.footballmanager.dto.team.TeamRequestDto;
import com.example.footballmanager.dto.team.TeamResponseDto;
import com.example.footballmanager.model.Team;

public interface TeamMapper {
    TeamResponseDto toDto(Team team);

    Team toModel(TeamRequestDto dto);
}
