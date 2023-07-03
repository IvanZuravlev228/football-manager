package com.example.footballmanager.controller;

import com.example.footballmanager.dto.player.PlayerRequestDto;
import com.example.footballmanager.dto.player.PlayerResponseDto;
import com.example.footballmanager.model.Player;
import com.example.footballmanager.service.PlayerService;
import com.example.footballmanager.service.mapper.PlayerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/players")
public class PlayerController {
    private final PlayerService playerService;
    private final PlayerMapper playerMapper;

    @GetMapping("/{id}")
    public PlayerResponseDto getById(@PathVariable Long id) {
        System.out.println("Get player by id: " + id);
        return playerMapper.toDto(playerService.getById(id));
    }

    @PostMapping
    public PlayerResponseDto addPlayer(@RequestBody PlayerRequestDto dto) {
        System.out.println("Add player: " + dto.toString());
        return playerMapper.toDto(playerService.save(playerMapper.toModel(dto)));
    }

    @PutMapping("/{id}")
    public PlayerResponseDto update(@PathVariable Long id,
                                    @RequestBody PlayerRequestDto dto) {
        System.out.println("Update player by id: " + id + "\nDto: " + dto);
        Player model = playerMapper.toModel(dto);
        model.setId(id);
        return playerMapper.toDto(playerService.save(model));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        System.out.println("Delete player by id: " + id);
        playerService.removeById(id);
    }
}
