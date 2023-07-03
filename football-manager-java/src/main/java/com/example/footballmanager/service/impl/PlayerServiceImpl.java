package com.example.footballmanager.service.impl;

import com.example.footballmanager.model.Player;
import com.example.footballmanager.repository.PlayerRepository;
import com.example.footballmanager.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;

    @Override
    public Player save(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public Player getById(Long id) {
        return playerRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Can't find player by id: " + id));
    }

    @Override
    public void removeById(Long id) {
        playerRepository.deleteById(id);
    }
}
