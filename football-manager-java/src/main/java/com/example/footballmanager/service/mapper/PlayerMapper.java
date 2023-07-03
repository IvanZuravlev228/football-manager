package com.example.footballmanager.service.mapper;

import com.example.footballmanager.dto.player.PlayerRequestDto;
import com.example.footballmanager.dto.player.PlayerResponseDto;
import com.example.footballmanager.model.Player;

public interface PlayerMapper {
    PlayerResponseDto toDto(Player player);

    Player toModel(PlayerRequestDto dto);
}
