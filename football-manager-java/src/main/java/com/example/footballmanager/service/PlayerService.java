package com.example.footballmanager.service;

import com.example.footballmanager.model.Player;

public interface PlayerService {
    Player save(Player player);

    Player getById(Long id);

    void removeById(Long id);
}
