package com.example.footballmanager.service.mapper.impl;

import com.example.footballmanager.dto.player.PlayerRequestDto;
import com.example.footballmanager.dto.player.PlayerResponseDto;
import com.example.footballmanager.model.Player;
import com.example.footballmanager.service.mapper.PlayerMapper;
import org.springframework.stereotype.Component;

@Component
public class PlayerMapperImpl implements PlayerMapper {
    @Override
    public PlayerResponseDto toDto(Player player) {
        PlayerResponseDto dto = new PlayerResponseDto();
        dto.setAge(player.getAge());
        dto.setId(player.getId());
        dto.setExperience(player.getExperience());
        dto.setLastName(player.getLastName());
        dto.setFirstName(player.getFirstName());
        dto.setCountryOfBirth(player.getCountryOfBirth());
        dto.setDateOfBirth(player.getDateOfBirth());
        return dto;
    }

    @Override
    public Player toModel(PlayerRequestDto dto) {
        Player player = new Player();
        player.setAge(dto.getAge());
        player.setExperience(dto.getExperience());
        player.setLastName(dto.getLastName());
        player.setFirstName(dto.getFirstName());
        player.setDateOfBirth(dto.getDateOfBirth());
        player.setCountryOfBirth(dto.getCountryOfBirth());
        return player;
    }
}
